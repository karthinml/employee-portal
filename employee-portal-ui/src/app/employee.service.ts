import { Injectable } from '@angular/core';
import {Employee} from "./model/employee";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {EMPLOYEE_SERVICE_URL} from "./app.constants";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient){ }

  private employeeServiceUrl: string = EMPLOYEE_SERVICE_URL;

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeServiceUrl);
  }

  addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.employeeServiceUrl, employee, {headers: this.httpOptions});
  }

  httpOptions: any = {'Content-Type':  'application/json'};

}
