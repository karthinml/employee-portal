import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListComponent } from './employee-list.component';
import {EmployeeService} from "../employee.service";
import {Employee} from "../model/employee";
import {Observable} from "rxjs";
import {HttpClientModule} from "@angular/common/http";
import {EMPLOYEE_LIST_COLUMN_DEFINITION, EMPLOYEE_LIST_SAMPLE_DATA} from "../app.constants";
import {AppComponent} from "../app.component";

fdescribe('EmployeeListComponent', () => {
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

  it('should have column definition property with column details', () => {
    expect(component.columnDefinition).toEqual(EMPLOYEE_LIST_COLUMN_DEFINITION);
  });

  it('Should call employee service and get employee list', () => {
        let employees = EMPLOYEE_LIST_SAMPLE_DATA;
        spyOn(employeeService, 'getEmployees').and
            .returnValue(new Observable<Employee[]>(subscriber => {
              subscriber.next(employees);
            }));
        component.ngOnInit();
        expect(employeeService.getEmployees).toHaveBeenCalled();
        expect(component.employees.length).toBe(1);
  });

  it('should have ag gird element', () => {
    const fixture = TestBed.createComponent(EmployeeListComponent);
    const gridElement = fixture.nativeElement.querySelector('ag-grid-angular');
    expect(gridElement).toBeTruthy();
  });

});
