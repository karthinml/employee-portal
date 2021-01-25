import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListComponent } from './employee-list.component';
import {EmployeeService} from "../employee.service";
import {Employee} from "../model/employee";
import {Observable} from "rxjs";
import {HttpClientModule} from "@angular/common/http";

describe('EmployeeListComponent', () => {
  let component: EmployeeListComponent;
  let fixture: ComponentFixture<EmployeeListComponent>;
  let employeeService: EmployeeService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListComponent ],
      providers: [EmployeeService],
      imports: [HttpClientModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    employeeService = TestBed.inject(EmployeeService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have employee list property initialized with empty array', () => {
    expect(component.employees).toEqual([]);
  });

  it('Should call employee service and get employee list', () => {
        let employees = [new Employee("1001", "Karthik",
                    "Ramasamy", "Male", new Date(), "J1Q")];
        spyOn(employeeService, 'getEmployees').and
            .returnValue(new Observable<Employee[]>(subscriber => {
              subscriber.next(employees);
            }));
        component.ngOnInit();
        expect(employeeService.getEmployees).toHaveBeenCalled();
        expect(component.employees.length).toBe(1);
  });

});
