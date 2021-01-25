export class Employee {
  employeeId: string;
  firstName: string;
  lastName: string;
  gender: string;
  dateOfBirth: Date;
  department: string;

  constructor(employeeId: string, firstName: string, lastName: string,
              gender: string, dateOfBirth: Date, department: string) {
    this.employeeId = employeeId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.department = department;
  }
}
