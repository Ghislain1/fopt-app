import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../shared/services/user-service';
import { Observable } from 'rxjs';
import { AppUser } from '../../../shared/models/app-user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users$: Observable<{}[]>;
  constructor(private userService: UserService) { }

  async ngOnInit() {
    this.users$ = await this.userService.getAll();
    this.log(this.users$);
  }

  private log(value: any): void {
    console.log(JSON.stringify(value, null, 4));
  }



}
