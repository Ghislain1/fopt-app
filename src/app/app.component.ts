import { Component, OnInit } from '@angular/core';
import { LoggerService } from './shared/services/logger.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  constructor(private loggerService: LoggerService) {

  }
  title = 'fopt-app';

  ngOnInit(): void {
    console.log("AppComponent Starting...");
    this.loggerService.info("AppComponent Starting...", true);
  }

}
