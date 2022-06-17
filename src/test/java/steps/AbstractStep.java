package steps;

import dto.GetJobStatusResponseDto;
import dto.ScheduleJobRequestDto;
import dto.ScheduleJobResponseDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractStep {

    protected static Response response;
    protected RequestSpecification requestSpecification;
    protected ScheduleJobRequestDto scheduleJobRequestDto;
    protected ScheduleJobResponseDto scheduleJobResponseDto;
    protected GetJobStatusResponseDto getJobStatusResponseDto;

    public AbstractStep() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://test.server.org")
                .build();
    }
}
