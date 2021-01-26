import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {NotificationComponent} from './notification.component';
import {NotificationService} from "./notification.service";
import {Observable} from "rxjs";

describe('NotificationComponent', () => {
  let component: NotificationComponent;
  let fixture: ComponentFixture<NotificationComponent>;
  let notificationService: NotificationService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NotificationComponent],
      providers: [NotificationService]
    })
      .compileComponents();
    notificationService = TestBed.inject(NotificationService);
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have message attribute initialized with empty string', () => {
    fixture.detectChanges();
    expect(component.message).toBe("");
  });

  it('should have background attribute initialized with none', () => {
    fixture.detectChanges();
    expect(component.background).toBe("none");
  });

  it('should have height attribute initialized with 0em', () => {
    fixture.detectChanges();
    expect(component.height).toBe("0em");
  });

  it('should check for empty sting when called isDefined', () => {
    fixture.detectChanges();
    expect(component.isDefined("")).toBeFalse();
    expect(component.isDefined("test")).toBeTrue();
  });

  it('should display message notification when the event is triggered', () => {
    let data = {"message": "Test message", "type": "success"};
    spyOn(notificationService, 'displayNotification').and.returnValue(new Observable(subscriber => {
      subscriber.next(data);
    }));
    spyOn(component, 'messageNotification');
    notificationService.notify(data.message, data.type);
    fixture.detectChanges();
    expect(component.message).toBe(data.message);
    expect(component.background).toBe('green');
    expect(component.height).toBe('3em');
    expect(component.messageNotification).toHaveBeenCalled();
  });

});
