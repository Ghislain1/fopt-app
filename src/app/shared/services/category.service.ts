import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { Category } from '../models/category';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  constructor(private angularFireDatabase: AngularFireDatabase) { }

  getAll(): Observable<{}[]> {
    return this.angularFireDatabase.list('/categories').valueChanges();
  }

}