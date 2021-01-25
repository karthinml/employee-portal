import { Injectable } from '@angular/core';
import {Employee} from "./model/employee";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient){ }

  private employeeServiceUrl: string = "http://localhost:8080/api/v1/employees"

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeServiceUrl);
  }

}
