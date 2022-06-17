package steps;
s
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
        String actualJobId = response.then().extract().path("jobId");
        assertThat(actualJobId)
                .as("jobId is empty string")
                .isNotEmpty();
    }

    @Then("The jobStatus is IN_PROGRESS")
    public void checkJobStatus() {
        String actualJobStatus = response.then().extract().path("jobStatus");

        //Utils.waitFor(120, , 10, "Waiting time jobStatus expired");
    }
}
