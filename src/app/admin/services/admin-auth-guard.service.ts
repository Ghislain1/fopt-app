import { Injectable } from '@angular/core';
import { AuthService } from '../../shared/services/auth.service';
import { CanActivate, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../../shared/services/user-service';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuard implements CanActivate {

  constructor(private auth: AuthService) {

  }

  canActivate() {

    return this.auth.user$.pipe(map((user: firebase.User) => {

      //TODO_Ghsilain:-- This Check is wrong!!
      if (user.email.length > 5) {
        console.log(user.uid);
        return true;
      }
      // Ghislai: if you are not a user please Login before 
      //this.router.navigate(['/app-login'], { queryParams: { returnUrl: state.url } });
      return false;
    }));
  }

}


