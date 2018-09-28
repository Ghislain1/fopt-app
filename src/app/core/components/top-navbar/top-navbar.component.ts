import { Component, OnInit } from '@angular/core';
import { AppUser } from '../../../shared/models/app-user';
import { AnsweredQuestion } from '../../../shared/models/answered-question';
import { Observable } from 'rxjs';
import { AnsweredQuestionService } from '../../../shared/services/answered-question.service';
import { AuthService } from '../../../shared/services/auth.service';

@Component({
  selector: 'app-top-navbar',
  templateUrl: './top-navbar.component.html',
  styleUrls: ['./top-navbar.component.css']
})
export class TopNavbarComponent implements OnInit {

  appUser: AppUser;
  answeredQ$: Observable<AnsweredQuestion>;

  constructor(private auth?: AuthService, private answeredQuestionService?: AnsweredQuestionService) {
  }

  async ngOnInit() {
    var fakeAppUser = {
      "name": "Fake User Admin!",
      "email": "string",
      "isAdmin": true
    };

    this.appUser = fakeAppUser;
    // this.auth.appUser$.subscribe(appUser => this.appUser = appUser);
    this.answeredQ$ = await this.answeredQuestionService.getAnsweredQ();
  }

  logout() {
    this.auth.logout();
  }

}