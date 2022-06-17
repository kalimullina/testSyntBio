package steps;

import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionSteps extends AbstractStep {


    @Then("The status code is {int}")
    public void checkStatusCode(int expectedStatusCode) {
        assertThat(response.getStatusCode())
                .as("Wrong status code in POST endpoint")
                .isEqualTo(expectedStatusCode);
    }

    @Then("The jobId is not empty string")
    public void checkJobIdEmptiness() {
        String actualJobId = response.then().extract().path("jobId");
        assertThat(actualJobId)
                .as("Wrong status code in POST endpoint")
                .isNotEmpty();
    }

    @Then("The jobStatus should be IN_PROGRESS or SUCCESS")
    public void checkJobStatus() {
        String actualJobStatus = response.then().extract().path("jobStatus");


    }
}
