import {Component, OnInit} from '@angular/core';
import {Employee} from "../model/employee";
import {EmployeeService} from "../employee.service";
import {EMPLOYEE_LIST_COLUMN_DEFINITION} from "../app.constants";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Array<Employee> = [];
  rowData: any = [];
  columnDefinition: any = EMPLOYEE_LIST_COLUMN_DEFINITION;

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(data => {
      this.employees = data;
    });
  }

}
