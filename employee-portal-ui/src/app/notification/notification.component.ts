import {Component, OnInit, OnDestroy} from '@angular/core';
import {NotificationService} from './notification.service';
import {Subscription} from 'rxjs';
import {NOTIFICATION_DISPLAY_DURATION_IN_SECONDS} from '../app.constants';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit, OnDestroy {

  message: string = "";
  background: string = 'none';
  height: string = '0em';
  notificationSubscription: Subscription;

  constructor(private notificationService: NotificationService) {
    this.notificationSubscription = this.notificationService.displayNotificatoin().subscribe(data => {
      this.message = data.message;
      let notificationType = data.type;
      if (this.isDefined(this.message)) {
        this.background = (notificationType == 'error') ? 'red' : 'green';
        this.height = '3em';
        this.messageNotification();
      }
    });
  }

  ngOnInit() {

  }

  ngOnDestroy() {
    this.notificationSubscription.unsubscribe();
  }

  isDefined(value: string) {
    return value != undefined && value != null && value != "";
  }

  messageNotification() {
    setTimeout(() => {
      this.message = '';
      this.background = 'none';
      this.height = '0em';
    }, NOTIFICATION_DISPLAY_DURATION_IN_SECONDS * 1000);
  }

}
