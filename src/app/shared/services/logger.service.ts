import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { NavigationStart, Router } from '@angular/router';


/**
 * To Log information in Console!!
 */
@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  private subject = new Subject<any>();
  private keepAfterNavigationChange = false;

  constructor(private router: Router) {
    // clear alert message on route change
    router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        if (this.keepAfterNavigationChange) {
          // only keep for a single location change
          this.keepAfterNavigationChange = false;
        } else {
          // clear alert
          this.subject.next();
        }
      }
    });
  }

  log(value: any, space?: number): void {



    console.log(value, null, space);
  }


  // TODO-Ghislain: Different way to provide a LoggerService

  info(message: string, keepAfterNavigationChange?: boolean) {
    this.keepAfterNavigationChange = keepAfterNavigationChange;
    this.subject.next({ type: 'info', text: message });
  }

  success(message: string, keepAfterNavigationChange?: boolean) {
    this.keepAfterNavigationChange = keepAfterNavigationChange;
    this.subject.next({ type: 'success', text: message });
  }

  error(message: string, keepAfterNavigationChange?: boolean) {
    this.keepAfterNavigationChange = keepAfterNavigationChange;
    this.subject.next({ type: 'error', text: message });
  }

  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }
}