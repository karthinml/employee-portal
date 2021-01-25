import { TestBed } from '@angular/core/testing';

import { EmployeeService } from './employee.service';
import {Employee} from "./model/employee";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";

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
    let employee = new Employee("1001", "Karthik",
      "Ramasamy", "Male", new Date(), "J1Q");
    let employees = [employee];
    spyOn(http, "get").withArgs("http://localhost:8080/api/v1/employees").and.returnValue(new Observable<Employee[]>(subscriber => {
        subscriber.next(employees);
    }));
    let actualResult;
    service.getEmployees().subscribe(data => { actualResult = data });
    expect(http.get).toHaveBeenCalled();
    expect(JSON.stringify(actualResult)).toEqual(JSON.stringify(employees));
  })
});
