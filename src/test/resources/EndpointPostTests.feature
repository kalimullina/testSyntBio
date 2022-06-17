Feature: Checking the work of endpoint which create a task to process entity

  Scenario: Send POST request with the correct entity ID
    Given The entity exists in the system
    When Create a task to process entity with the correct entity id "1"
    Then The status code is 200
    And The jobId is not empty string

  Scenario Outline: Send POST request with the incorrect entity ID
    Given The entity exists in the system
    When Create a task to process entity with the incorrect entity id "<incorrectId>"
    Then The status code is 200
    And The jobId is not empty string

  Examples:
    | incorrectId |
    |    10000    |
    |    10m!0    |
    |    null     |