import {Employee} from "./model/employee";

export const EMPLOYEE_SERVICE_URL = "http://localhost:8080/api/v1/employees";
export const NOTIFICATION_DISPLAY_DURATION_IN_SECONDS = 10;

export const EMPLOYEE_LIST_SAMPLE_DATA: Employee[] = [new Employee("1001", "Karthik",
  "Ramasamy", "Male", new Date(), "J1Q")];


export const EMPLOYEE_LIST_COLUMN_DEFINITION = [
  {headerName: 'Employee ID', field: 'employeeId'},
  {headerName: 'First Name', field: 'firstName'},
  {headerName: 'Last Name', field: 'lastName'},
  {headerName: 'Gender', field: 'gender'},
  {
    headerName: 'Date Of Birth', field: 'dateOfBirth', cellRenderer: (data: { value: string | number | Date; }) => {
      return data.value ? (new Date(data.value)).toLocaleDateString() : '';
    }
  },
  {headerName: 'Department', field: 'department'}
];
