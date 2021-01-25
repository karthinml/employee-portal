import { TestBed } from '@angular/core/testing';

import { EmployeeService } from './employee.service';
import {Employee} from "./model/employee";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {EMPLOYEE_LIST_SAMPLE_DATA, EMPLOYEE_SERVICE_URL} from './app.constants';

describe('EmployeeService', () => {
  let service: EmployeeService;
  let http: HttpClient;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule]
    });
    service = TestBed.inject(EmployeeService);
    http = TestBed.inject(HttpClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get list of employees', () => {
    let employees = EMPLOYEE_LIST_SAMPLE_DATA;
    spyOn(http, "get").withArgs(EMPLOYEE_SERVICE_URL).and.returnValue(new Observable<Employee[]>(subscriber => {
        subscriber.next(employees);
    }));
    let actualResult = undefined;
    service.getEmployees().subscribe(data => { actualResult = data });
    expect(http.get).toHaveBeenCalled();
    expect(JSON.stringify(actualResult)).toEqual(JSON.stringify(employees));
  })
});
