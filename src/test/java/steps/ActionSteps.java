package steps;

import dto.ScheduleJobRequestDto;
import dto.ScheduleJobResponseDto;
import io.cucumber.java.en.When;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ActionSteps extends AbstractStep {

    @When("Create a task to process entity with the correct entity id {string}")
    public void createTaskWithEntityId(String correctEntityId) {
        ScheduleJobRequestDto scheduleJobRequestDto = new ScheduleJobRequestDto(correctEntityId);
        response = given(requestSpecification)
                .contentType("application/json")
                .body(scheduleJobRequestDto)
                .when()
                .post("/scheduleJob");
    }

    @When("^Create a task to process entity with the incorrect entity id \"([^\"]*)\"$")
    public void createTaskWithIncorrectEntityId(String incorrectEntityId) {
        if (Objects.equals(incorrectEntityId, "null"))
            incorrectEntityId = "";

        ScheduleJobRequestDto scheduleJobRequestDto = new ScheduleJobRequestDto(incorrectEntityId);
        response = given(requestSpecification)
                .contentType("application/json")
                .body(scheduleJobRequestDto)
                .when()
                .post("/scheduleJob");
    }

    @When("Send GET request using jobId from previous response")
    public void sendGetRequestToCheckCreatedTask() {
        jobId = response.as(ScheduleJobResponseDto.class).getJobId();

        response = given(requestSpecification)
                .pathParam("jobId", jobId)
                .when().get("/job/{jobId}");
    }

    @When("^Send GET request with the incorrect jobId \"([^\"]*)\"$")
    public void sendGetRequest(String jobId) {
        if (Objects.equals(jobId, "null"))
            jobId = "";

        response = given(requestSpecification)
                .pathParam("jobId", jobId)
                .when().get("/job/{jobId}");
    }
}
