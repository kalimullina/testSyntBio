package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractStep {

    protected static Response response;
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://test.server.org")
            .build();
}
