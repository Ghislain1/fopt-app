import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Router, RouterStateSnapshot, CanActivate } from '@angular/router';
import { map } from 'rxjs/operators';


// TODO:Ghislain - What does this class?
@Injectable({
  providedIn: 'root' // TODO-GHislain-  What does mean??
})
export class AuthGuard implements CanActivate {

  constructor(private auth: AuthService, private router: Router) {

  }

  canActivate(route, state: RouterStateSnapshot) {
    return this.auth.user$.pipe(map((user: firebase.User) => {
      if (user) {
        console.log(user.uid);
        return true;
      }
      // Ghislai: if you are not a user please Login before 
      this.router.navigate(['/app-login'], { queryParams: { returnUrl: state.url } });
      return false;
    }));
  }

}
