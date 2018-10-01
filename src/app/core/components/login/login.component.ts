import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../shared/services/auth.service';
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { LoggerService } from '../../../shared/services/logger.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any = {}; // TODO-Ghislain: why this proprerty?
  loading = false;  // TODO-Ghislain: why this proprerty?
  returnUrl: string;  // TODO-Ghislain: why this proprerty?
  message: any;
  messages: any[] = [];
  constructor(private route: ActivatedRoute,
    private router: Router,
    private loggerService: LoggerService,
    private authService: AuthService) {


    this.loggerService.getMessage().subscribe(observer => {
      this.message = observer;
      this.messages.push(this.message);
    })
  }

  ngOnInit() {
    this.loggerService.info("logout");
    // reset login status
    this.authService.logout();
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }


  login() {
    this.loading = true;
    this.authService.login().then(function () {
      console.log('this.returnUrl + admin/questions/new');
      this.router.navigate([this.returnUrl + 'admin/questions/new']);
    });
    this.loading = false;
  }

  loginWithGoogle() {
    this.loading = true;
    this.loggerService.info('LoginComponent--> loginWithGoogle()', true);
    this.authService.loginWithGoogle().then((data) => this.navigate(data));
    this.loggerService.info('LoginComponent--> loginWithGoogle()', true);

  }

  navigate(data: firebase.auth.UserCredential) {
    if (data.user) {
      console.log(data.user + ' this.returnUrl + admin/questions/new');
      // this.router.navigate(['admin/questions/new']);
      console.log(data.user.displayName);
      console.log(data.user.providerId);
      const url = this.returnUrl + 'admin/question/lists';
      this.router.navigate([url]);
    }

  }
}
