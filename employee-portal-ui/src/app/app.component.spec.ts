import {ComponentFixture, TestBed} from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {AppComponent} from './app.component';
import {EmployeeListComponent} from "./employee-list/employee-list.component";

describe('AppComponent', () => {

  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
  });

  it('should create the app', () => {
    expect(component).toBeTruthy();
  });

  it(`should have as title 'Employee Portal'`, () => {
    expect(component.title).toEqual('Employee Portal');
  });

  it(`should display employee list table`, () => {
    fixture.detectChanges();
    const empListElement = fixture.nativeElement.querySelector('app-employee-list');
    expect(empListElement).toBeTruthy();
  });

  it('should open registration form when clicked on register button', () => {
    component.registerEmployee = true;
    fixture.detectChanges();
    const empListElement = fixture.nativeElement.querySelector('app-employee-registration');
    expect(empListElement).toBeTruthy();
  })

});
