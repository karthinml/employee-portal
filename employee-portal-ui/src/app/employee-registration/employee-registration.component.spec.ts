import {ComponentFixture, TestBed} from '@angular/core/testing';
import {EmployeeRegistrationComponent} from './employee-registration.component';
import {NotificationService} from "../notification/notification.service";
import {EmployeeService} from "../employee.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MatRadioModule} from "@angular/material/radio";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatInputModule} from "@angular/material/input";
import {MatNativeDateModule} from "@angular/material/core";
import {MatButtonModule} from "@angular/material/button";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {Employee} from "../model/employee";
import {Observable} from "rxjs";
import {By} from "@angular/platform-browser";
import {EMPLOYEE_LIST_SAMPLE_DATA} from "../app.constants";

describe('EmployeeRegistrationComponent', () => {
  let component: EmployeeRegistrationComponent;
  let fixture: ComponentFixture<EmployeeRegistrationComponent>;
  let employeeService: EmployeeService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmployeeRegistrationComponent],
      providers: [NotificationService, EmployeeService],
      imports: [FormsModule, HttpClientModule, ReactiveFormsModule, MatRadioModule,
        MatDatepickerModule, MatInputModule, MatNativeDateModule, MatButtonModule, BrowserAnimationsModule]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    employeeService = TestBed.inject(EmployeeService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should emit close registration page event on click of close button', () => {
    const close_btn = fixture.nativeElement.querySelector('#close_btn');
    let closeEventValue = null;
    component.closeRegistrationPage.subscribe((value: boolean) => {
      closeEventValue = value;
    });
    close_btn.click();
    fixture.detectChanges();
    expect(closeEventValue).toBeTrue();
  });

  it('should call registerEmployee function on click of Register button', () => {
    spyOn(component, 'registerEmployee');
    const registerButton = fixture.debugElement.query(By.css('#register_btn'));
    registerButton.triggerEventHandler('click', null);
    fixture.whenStable().then(() => {
      expect(component.registerEmployee).toHaveBeenCalled();
    });
  });

  it('should call employee service and register employee successfully', () => {
    spyOn(employeeService, 'addEmployee').and.returnValue(new Observable<Employee>(subscriber => {
      subscriber.next(EMPLOYEE_LIST_SAMPLE_DATA[0])
    }));
    fixture.detectChanges();
    component.registerEmployee(EMPLOYEE_LIST_SAMPLE_DATA[0]);
    expect(employeeService.addEmployee).toHaveBeenCalled();
  });

});
