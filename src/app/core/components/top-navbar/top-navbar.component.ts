import { Component, OnInit } from '@angular/core';
import { AppUser } from '../../../shared/models/app-user';
import { AnsweredQuestion } from '../../../shared/models/answered-question';
import { Observable } from 'rxjs';
import { AnsweredQuestionService } from '../../../shared/services/answered-question.service';
import { AuthService } from '../../../shared/services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-top-navbar',
  templateUrl: './top-navbar.component.html',
  styleUrls: ['./top-navbar.component.css']
})
export class TopNavbarComponent implements OnInit {


  appUser: AppUser;
  appUser$: Observable<AppUser>;
  answeredQ$: Observable<AnsweredQuestion>;

  constructor(private authService: AuthService, private router: Router, private answeredQuestionService?: AnsweredQuestionService) {


    this.appUser$ = this.authService.appUser$;
  }




  async  ngOnInit() {


    this.authService.appUser$.subscribe(appUser => {


      if (appUser !== null) {
        this.appUser = appUser

        if (this.appUser.isAdmin) {
          this.appUser.displayName = this.appUser.displayName.concat(' (Admin)');
          this.router.navigate(['./app-admin-question-list']);
        }
        else {
          this.router.navigate(['./app-question-filter']);
        }

      } else {
        this.router.navigate(['/']);
      }
    }
    );

    this.answeredQ$ = await this.answeredQuestionService.getAnsweredQ();


  }

  logout() {
    this.authService.logout();
  }

  private log(value: any): void {
    console.log(JSON.stringify(value, null, 3));
  }

}
