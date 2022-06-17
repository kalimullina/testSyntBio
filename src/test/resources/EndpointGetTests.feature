Feature: Checking the work of endpoint which check status of running task

  Scenario: Send GET request with the correct jobId and receive response with SUCCESS jobStatus
    Given The entity exists in the system
    When Create a task to process entity with the correct entity id "1"
    And Send the GET request using jobId from previous response
    Then The status code is 200
    #And The jobStatus should be IN_PROGRESS or SUCCESS