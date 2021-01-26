import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = 'Employee Portal';
  registerEmployee: boolean = false;

  registrationFormVisible(visibility: boolean) {
    this.registerEmployee = visibility;
  }

  onCloseRegistration(value: boolean) {
    this.registerEmployee = !value;
  }
}
