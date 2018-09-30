import { Injectable } from '@angular/core';


/**
 * To Log information in Console!!
 */
@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  constructor() {

  }

  log(value: any, space?: number): void {
    console.log(value, null, space);
  }
}
