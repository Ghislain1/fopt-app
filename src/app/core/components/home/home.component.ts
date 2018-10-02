import { Component, OnInit } from '@angular/core';
import { NgbProgressbarConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [NgbProgressbarConfig] //TODO_GHislain: why hier? add the NgbProgressbarConfig to the component providers]
})
export class HomeComponent implements OnInit {
  textTooltip: string;
  currentRate: number;
  constructor(private config: NgbProgressbarConfig) {
    this.log("ngOnInit");

  }

  ngOnInit() {
    // customize default values of progress bars used by this component tree
    this.config.max = 1000;
    this.config.striped = true;
    this.config.animated = true;
    this.config.type = 'success';
    this.config.height = '20px';


    //Tooltip
    this.textTooltip = "World";

    //Rating!!!..
    this.currentRate = 8;
    this.log("ngOnInit");

  }

  private log(value: any): void {
    console.log(JSON.stringify(value, null, 3));
  }

}
