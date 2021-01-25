import {Employee} from "./model/employee";

export const EMPLOYEE_SERVICE_URL = "http://localhost:8080/api/v1/employees";

export const EMPLOYEE_LIST_SAMPLE_DATA: Employee[] = [new Employee("1001", "Karthik",
  "Ramasamy", "Male", new Date(), "J1Q")];
