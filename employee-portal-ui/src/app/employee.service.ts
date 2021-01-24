import { Injectable } from '@angular/core';
import {Employee} from "./model/employee";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient){ }

  getEmployees(): Observable<Employee[]> {
    return new Observable<Employee[]>();
  }

}
