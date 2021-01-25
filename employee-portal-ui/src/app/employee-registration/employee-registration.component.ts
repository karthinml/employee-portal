import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Employee} from "../model/employee";
import {EMPLOYEE_LIST_SAMPLE_DATA} from "../app.constants";

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {

  registrationForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.registrationForm = this.formBuilder.group({
      employeeId: new FormControl("employeeId", Validators.required),
      firstName: new FormControl("firstName", Validators.required),
      lastName: new FormControl("lastName", Validators.required),
      gender: new FormControl("gender", Validators.required),
      dateOfBirth: new FormControl("dateOfBirth", Validators.required),
      department: new FormControl("department", Validators.required)
    });
  }

  ngOnInit(): void {

  }

  registerEmployee(employee: Employee): Employee {
    return EMPLOYEE_LIST_SAMPLE_DATA[0];
  }
}
