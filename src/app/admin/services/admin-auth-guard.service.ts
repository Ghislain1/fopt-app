import { Injectable } from '@angular/core';
import { AuthService } from '../../shared/services/auth.service';
import { CanActivate, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../../shared/services/user-service';
import { map } from 'rxjs/operators';
import { AppUser } from '../../shared/models/app-user';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuard implements CanActivate {

  constructor(private authService: AuthService) {

  }

  canActivate(): Observable<boolean> {

    return this.authService.appUser$.pipe(map((appUser: AppUser) => appUser.isAdmin));
  }
}

    //   //TODO_Ghsilain:-- This Check is wrong!!
    //   if (user.is < 0) {
    //     console.log(user.uid);
    //     return true;
    //   }
    //   // Ghislai: if you are not a user please Login before 
    //   //this.router.navigate(['/app-login'], { queryParams: { returnUrl: state.url } });
    //   return false;
    // }));


