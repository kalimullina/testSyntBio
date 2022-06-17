import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@CucumberOptions(features = "src/test/resources",
        glue="steps")
public class RunTest extends AbstractTestNGCucumberTests {


    /*@Test
    void withoutCucumber() {

        Integer entityId = 1;

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://test.server.org/scheduleJob")
                .build();

        given(requestSpecification)
                .body(String.format("{id: %s}", entityId))
                .when()
                .post("https://test.server.org/scheduleJob")
                .then()
                .assertThat()
                .statusCode(200);

        *//*Integer entityId = 1;

        RestAssured
                .given()
                .body(String.format("{id: %s}", entityId))
                .when()
                .post("https://test.server.org/scheduleJob")
                .then()
                .assertThat()
                .statusCode(200);*//*
    }*/
}
