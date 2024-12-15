Feature: CalcController

  Scenario: Add two positive numbers
    Given the numbers 5 and 3
    When I add them together
    Then the result should be 8

  Scenario: Add zero
    Given the numbers 0 and 0
    When I add them together
    Then the result should be 0

  Scenario: Add two negative numbers
    Given the numbers -5 and -3
    When I add them together
    Then the result should be -8

