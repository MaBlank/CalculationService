Feature: Calculation Service

  Scenario: Add two positive numbers
    Given the calculation service is running
    When I send a request to add 5 and 3
    Then the response should be 8

  Scenario: Add a positive and a negative number
    Given the calculation service is running
    When I send a request to add 5 and -3
    Then the response should be 2

  Scenario: Add two negative numbers
    Given the calculation service is running
    When I send a request to add -5 and -3
    Then the response should be -8

  Scenario: Add zero to a number
    Given the calculation service is running
    When I send a request to add 5 and 0
    Then the response should be 5

  Scenario Outline: Add various number combinations
    Given the calculation service is running
    When I send a request to add <number1> and <number2>
    Then the response should be <result>

    Examples:
      | number1 | number2 | result |
      | 10      | 20      | 30     |
      | -10     | 20      | 10     |
      | 0       | 0       | 0      |
      | 999     | 1       | 1000   |
      | -500    | -500    | -1000  |
