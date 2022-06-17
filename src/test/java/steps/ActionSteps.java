package steps;

import io.cucumber.java.en.When;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ActionSteps extends AbstractStep {

    @When("Create a task to process entity with the correct entity id {string}")
    @When("Create a task to process entity with the incorrect entity id {string}")
    public void createTaskWithEntityId(String correctEntityId) {

        response = given(requestSpecification)
                .body("id : " + correctEntityId)
                .when()
                .post("/scheduleJob");
    }

    @When("^Create a task to process entity with the incorrect entity id \"([^\"]*)\"$")
    public void createTaskWithIncorrectEntityId(String incorrectEntityId) {
        if (Objects.equals(incorrectEntityId, "null"))
            incorrectEntityId = "";

        response = given(requestSpecification)
                .body("id : " + incorrectEntityId)
                .when()
                .post("/scheduleJob");
    }

    @When("Send GET request using jobId from previous response")
    public void sendGetRequestToCheckCreatedTask() {
        String jobId = response.then().extract().path("jobId");

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
