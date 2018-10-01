import { Injectable } from '@angular/core';
import { Observable, observable, of } from 'rxjs';
import { switchMap, defaultIfEmpty } from 'rxjs/operators';
import { UserService } from './user-service';
import { AngularFireAuth } from 'angularfire2/auth';
import { ActivatedRoute } from '@angular/router';
import * as firebase from 'firebase';
import { AppUser } from '../models/app-user';
import { LoggerService } from './logger.service';


@Injectable()
export class AuthService {
  user$: Observable<firebase.User>;

  constructor(
    private userService: UserService,
    private afAuth: AngularFireAuth, //TODO:Ghislain- can you explain this?
    private loggerService: LoggerService,
    private route: ActivatedRoute) {
    this.user$ = afAuth.authState;
  }


  login() {

    const returnUrl = this.route.snapshot.queryParamMap.get('returnUrl') || '/';

    localStorage.setItem('returnUrl', returnUrl);

    const fa = this.afAuth.auth.signInWithRedirect(new firebase.auth.GoogleAuthProvider());

    return fa;
  }

  logout() {
    this.log('logout');
    // this.afAuth.auth.signOut().then(function () {
    //   console.log('// Sign-out successful.');
    // }, function (error) {
    //   console.log(error);
    // });
  }

  getRedirectResult() {
    return this.afAuth.auth.getRedirectResult();
  }

  /**
   * Login with Google account by calling a Method signInWithPopup()
   */
  loginWithGoogle() {
    const returnUrl = this.route.snapshot.queryParamMap.get('returnUrl') || '/';
    localStorage.setItem('returnUrl', returnUrl);
    const provider = new firebase.auth.GoogleAuthProvider();
    this.loggerService.info('AuthService--> loginWithGoogle()', true);
    return this.afAuth.auth.signInWithPopup(provider);
  }

  /**
  * Handler "login with google" --> Possibilility 2
  */
  loginWithGoogle1() {

    //TODO-Ghislain: Diffrence beetween signInWithRedirect and signInWithPopup???
    firebase.auth().setPersistence(firebase.auth.Auth.Persistence.LOCAL)
      .then(function () {
        const provider = new firebase.auth.GoogleAuthProvider();
        // In memory persistence will be applied to the signed in Google user
        // even though the persistence was set to 'none' and a page redirect
        // occurred.
        console.log('Call signInWithPopup');
        return firebase.auth().signInWithPopup(provider)
      })
      .catch(function (error) {
        // Handle Errors here.
        console.log(error);
        const errorCode = error.code;
        const errorMessage = error.message;
      });
  }

  get appUser$(): Observable<AppUser> {
    return this.user$.pipe(switchMap(user => {
      if (user) {
        let userApp = {
          displayName: user.displayName,
          email: user.email,
          isAdmin: user.email.length > 4 ? true : false, //TODO-Ghislain--> How to ask firebase if the user is an Admin?
        }

        return of(userApp);
      }

      alert("NO a UserApp");
      return of(user as any);

    }));
  }

  private log(value: any): void {
    console.log(JSON.stringify(value, null, 3));
  }
}
