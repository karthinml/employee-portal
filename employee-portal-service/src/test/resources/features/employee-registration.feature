@registration
Feature: Register employee to the employee portal.

  Scenario: User should be able to register an employee to employee portal with all valid parameters.
    Given the user register an employee with below attributes
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Karthik   | Ramasamy | Male   | 08-16-1989  | J1Q        |
    When the user makes request to register and employee in employee portal
    Then the employee will be registered to employee portal
    And the user gets below response with status code 201
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Karthik   | Ramasamy | Male   | 08-16-1989  | J1Q        |


  Scenario: User should get exception when trying to register an employee who is already registered in employee portal.
    Given the list of employees registered in employee portal
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Shiva     | Prasad   | Male   | 11-10-1989  | J1Q        |
    And the user register an employee with below attributes
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Karthik   | Ramasamy | Male   | 08-16-1989  | J1Q        |
    When the user makes request to register and employee in employee portal
    Then the user get error response as "Employee already registered" with status code 409


  Scenario Outline: User should get exception when trying to register an employee with missing attributes.
    Given the user register an employee with below attributes
      | employeeId   | firstName   | lastName   | gender   | dateOfBirth   | department   |
      | <employeeId> | <firstName> | <lastName> | <gender> | <dateOfBirth> | <department> |
    When the user makes request to register and employee in employee portal
    Then the user will get error messages as "<errorMessages>" with status code 400

    Examples:
      | employeeId | firstName | lastName | gender | dateOfBirth | department | errorMessages                                                  |
      |            | Shiva     | Prasad   | Male   | 11-10-1989  | J1Q        | Employee ID field is mandatory                                 |
      | 1001       |           |          | Male   | 11-10-1989  | J1Q        | First name field is mandatory,Last name field is mandatory     |
      | 1001       | Shiva     | Prasad   |        | 11-10-1989  |            | Gender field is mandatory,Department field is mandatory        |
      | 1001       | Shiva     | Prasad   | Male   |             |            | Date of birth field is mandatory,Department field is mandatory |
