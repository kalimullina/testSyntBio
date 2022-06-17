Feature: Checking the work of endpoint which check status of running task

  Scenario: Send GET request with the correct jobId and receive response with SUCCESS jobStatus
    Given The entity exists in the system
    When Create a task to process entity with the correct entity id "1"
    And Send GET request using jobId from previous response
    Then The status code is 200
    And The jobStatus is IN_PROGRESS
    And After 2 minutes jobStatus is SUCCESS


  Scenario Outline: Send GET request with the incorrect jobId
    When Send GET request with the incorrect jobId "<incorrectJobId>"
    Then The status code is 404
  Examples:
      | incorrectJobId |
      |    10000       |
      |    10m!0       |
      |    null        |


  Scenario: Send POST request with the incorrect entity id, send GET request and receive response with ERROR jobStatus
    When Create a task to process entity with the incorrect entity id "10000"
    And Send GET request using jobId from previous response
    Then The status code is 200
    And The jobStatus is ERROR
