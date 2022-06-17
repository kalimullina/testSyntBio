package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractStep {

    protected static Response response;
    protected RequestSpecification requestSpecification;

    public AbstractStep() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://test.server.org")
                .build();
    }
}
