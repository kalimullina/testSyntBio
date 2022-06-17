package steps;

import dto.GetJobStatusResponseDto;
import dto.ScheduleJobResponseDto;
import io.cucumber.java.en.Then;

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

        //Utils.waitFor(120, , 10, "Waiting time jobStatus expired");
    }

    @Then("After 2 minutes jobStatus is SUCCESS")
    public void checkJobStatusSuccess() {
        String actualJobStatus = response.as(GetJobStatusResponseDto.class).getJobStatus();

    }

    @Then("The jobStatus is ERROR")
    public void checkJobStatusError() {
        String actualJobStatus = response.as(GetJobStatusResponseDto.class).getJobStatus();

    }
}
