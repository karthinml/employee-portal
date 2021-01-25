@employeelist
Feature: Get all the employees registered in employee portal

  Scenario: User will get empty list when there is no employees registered in employee portal.
    When the user make request to get employees registered in portal
    Then the service will response with status code 200
    And the user will get empty list

  Scenario: User will get employees registered in portal in ascending order by first name
    Given users registered in employee portal
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Karthik   | Ramasamy | Male   | 08-16-1989  | J1Q        |
      | 1002       | Arun      | Kumar    | Male   | 02-11-1992  | J1H        |
    When the user make request to get employees registered in portal
    Then the service will response with status code 200
    And the user will get the below list of employees with the same order
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1002       | Arun      | Kumar    | Male   | 02-11-1992  | J1H        |
      | 1001       | Karthik   | Ramasamy | Male   | 08-16-1989  | J1Q        |