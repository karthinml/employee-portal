import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Employee} from "../model/employee";
import {EMPLOYEE_LIST_SAMPLE_DATA} from "../app.constants";
import {EmployeeService} from "../employee.service";
import {NotificationService} from "../notification/notification.service";

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {

  @Output() closeRegistrationPage: EventEmitter<boolean> = new EventEmitter<boolean>();

  registrationForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private employeeService: EmployeeService,
              private notificationService: NotificationService) {
    this.registrationForm = this.formBuilder.group({
      employeeId: new FormControl("", Validators.required),
      firstName: new FormControl("", Validators.required),
      lastName: new FormControl("", Validators.required),
      gender: new FormControl("", Validators.required),
      dateOfBirth: new FormControl("", Validators.required),
      department: new FormControl("", Validators.required)
    });
  }

  ngOnInit(): void {

  }

  registerEmployee(employee: Employee) {
    this.employeeService.addEmployee(employee).subscribe(data => {
      this.notificationService.notify("Employee registration success!!", "success");
      this.closeRegistrationPage.emit(true);
    }, error => {
      setTimeout(() => {
      }, 10000)
      this.notificationService.notify("Employee registration failed!!", "error");
    });
  }

  close(value: boolean) {
    this.closeRegistrationPage.emit(true);
  }
}
