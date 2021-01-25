import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {HttpClientModule} from "@angular/common/http";
import {AgGridModule} from 'ag-grid-angular';
import {EmployeeRegistrationComponent} from './employee-registration/employee-registration.component'
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatButtonModule} from "@angular/material/button";
import {MatRadioModule} from "@angular/material/radio";
import {MatNativeDateModule} from "@angular/material/core";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {NotificationComponent} from "./notification/notification.component";
import {NotificationService} from "./notification/notification.service";

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeRegistrationComponent,
    NotificationComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    AgGridModule.withComponents([]),
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCheckboxModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
