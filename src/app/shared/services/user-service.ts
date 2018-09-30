import { Injectable } from '@angular/core';
import { AngularFireDatabase, AngularFireObject, AngularFireList } from 'angularfire2/database';
import { AppUser } from '../models/app-user';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {

  usersRef: AngularFireList<{}[]>;
  constructor(private angularFireDatabase: AngularFireDatabase) {

    this.usersRef = this.angularFireDatabase.list('/users');

  }

  /**
  Provide list of users from fireBase base!!!
  Der Typ "Observable<{}[]>"
  */
  getAll(): Observable<{}[]> {

    return this.usersRef.valueChanges();
  }


  // save(user: firebase.User) {
  //   this.db.object('/users/' + user.uid).update({
  //     name: user.displayName,
  //     email: user.email
  //   });
  // }

  get(uid: string): AngularFireObject<AppUser> {

    return this.angularFireDatabase.object('/users/' + uid);
  }
}
