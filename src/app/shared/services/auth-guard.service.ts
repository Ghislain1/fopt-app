import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Router, RouterStateSnapshot } from '@angular/router';
import { map } from 'rxjs/operators';


// TODO:Ghislain - What does this class?
@Injectable({
  providedIn: 'root' // TODO-GHislain-  What does mean??
})
export class AuthGuard {

  constructor(private auth: AuthService, private router: Router) {

  }

  canActivate(route, state: RouterStateSnapshot) {
    return this.auth.user$.pipe(map(user => {
      if (user) {
        alert('oo');

        return true;
      }
      this.router.navigate(['/app-login'], { queryParams: { returnUrl: state.url } });
      return false;
    }));
  }

}
