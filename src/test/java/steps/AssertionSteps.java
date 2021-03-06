package steps;

import dto.GetJobStatusResponseDto;
import dto.ScheduleJobResponseDto;
import io.cucumber.java.en.Then;

import java.util.concurrent.Callable;

import static entities.JobStatus.ERROR;
import static entities.JobStatus.IN_PROGRESS;
import static entities.JobStatus.SUCCESS;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertionSteps extends AbstractStep {


    @Then("The status code is {int}")
    public void checkStatusCode(int expectedStatusCode) {
        assertThat(response.getStatusCode())
                .as("Wrong status code")
                .isEqualTo(expectedStatusCode);
    }

    @Then("The jobId is not empty string")
    public void checkJobIdEmptiness() {
        ScheduleJobResponseDto scheduleJobResponseDto = response.as(ScheduleJobResponseDto.class);
        assertThat(scheduleJobResponseDto.getJobId())
                .as("jobId is empty string")
                .isNotEmpty();
    }

    @Then("The jobStatus is IN_PROGRESS")
    public void checkJobStatusInProgress() {
        String actualJobStatus = response.as(GetJobStatusResponseDto.class).getJobStatus();
        assertThat(actualJobStatus)
                .as("Actual jobStatus is not IN_PROGRESS")
                .isEqualTo(IN_PROGRESS.toString());
    }

    @Then("After several seconds jobStatus is SUCCESS")
    public void checkJobStatusSuccess() throws Exception {
        //String actualJobStatus = response.as(GetJobStatusResponseDto.class).getJobStatus();

        Callable<Boolean> action = () -> {
            response = given(requestSpecification)
                    .pathParam("jobId", jobId)
                    .when().get("/job/{jobId}");
            //actualJobStatus = response.as(GetJobStatusResponseDto.class).getJobStatus();

            return SUCCESS.toString().equalsIgnoreCase(response.as(GetJobStatusResponseDto.class).getJobStatus());
        };

        Utils.waitFor(120, action, 10, "Waiting time SUCCESS jobStatus expired");
    }

    @Then("After several seconds jobStatus is ERROR")
    public void checkJobStatusError() {
        String actualJobStatus = response.as(GetJobStatusResponseDto.class).getJobStatus();

        Callable<Boolean> action = () -> ERROR.toString().equalsIgnoreCase(actualJobStatus);

        Utils.waitFor(120, action, 10, "Waiting time ERROR jobStatus expired");
    }
}
