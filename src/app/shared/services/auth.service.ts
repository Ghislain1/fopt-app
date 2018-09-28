import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { switchMap, defaultIfEmpty } from 'rxjs/operators';
import { UserService } from './user-service';
import { AngularFireAuth } from 'angularfire2/auth';
import { ActivatedRoute } from '@angular/router';
import * as firebase from 'firebase';
import { AppUser } from '../models/app-user';




@Injectable()
export class AuthService {
  user$: Observable<firebase.User>;

  constructor(
    private userService: UserService,
    //  private afAuth: AngularFireAuth,
    private route: ActivatedRoute) {

    //  this.user$ = afAuth.authState;
  }

  login() {
    let returnUrl = this.route.snapshot.queryParamMap.get('returnUrl') || '/';
    localStorage.setItem('returnUrl', returnUrl);

    // this.afAuth.auth.signInWithRedirect(new firebase.auth.GoogleAuthProvider());
  }

  logout() {
    //  this.afAuth.auth.signOut();
  }

  get appUser$(): Observable<AppUser> {

    //TODO-Ghislain: get user app from database!!.
    return new Observable<AppUser>();
  }
}