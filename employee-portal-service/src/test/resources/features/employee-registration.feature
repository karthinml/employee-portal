Feature: Register employee to the employee portal.

  Scenario: User should be able to register an employee to employee portal with all valid parameters.
    Given the user register an employee with below attributes
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Karthik   | Ramasamy | Male   | 16/08/1989  | J1Q        |
    When the user makes request to register in employee portal
    Then the employee will be registered to employee portal
    And the user gets below response with status code 201
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Karthik   | Ramasamy | Male   | 16/08/1989  | J1Q        |


  Scenario: User should get exception when trying to register an employee who is already registered in employee portal.
    Given the list of employees registered in employee portal
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Shiva   | Prasad | Male   | 11/10/1989  | J1Q        |
    And the user register an employee with below attributes
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Karthik   | Ramasamy | Male   | 16/08/1989  | J1Q        |
    When the user makes request to register in employee portal
    Then the user get error response as "Employee already registered" with status code 409


  Scenario: User should get exception when trying to register an employee with missing employee id.
    Given the user register an employee with below attributes
      | employeeId | firstName | lastName | gender | dateOfBirth | department |
      | 1001       | Karthik   | Ramasamy | Male   | 16/08/1989  | J1Q        |
    When the user makes request to register in employee portal
    Then the user get error response as "Invalid request parameter" with status code 400