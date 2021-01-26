import {Injectable} from "@angular/core";
import {Subject, Observable} from 'rxjs';

@Injectable()
export class NotificationService {
  private notification = new Subject<any>();

  notify(errorMessage: string, errorType: string) {
    this.notification.next({"message": errorMessage, "type": errorType});
  }

  displayNotification(): Observable<any> {
    return this.notification.asObservable();
  }
}
