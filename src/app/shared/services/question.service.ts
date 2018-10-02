import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private angularFireDatabase: AngularFireDatabase) { }

  create(question) {
    return this.angularFireDatabase.list('/questions').push(question);
  }

  getAll() {
    return this.angularFireDatabase.list('/questions').valueChanges();
  }

  get(questionId) {
    return this.angularFireDatabase.object('/questions/' + questionId);
  }

  update(questionId, question) {
    return this.angularFireDatabase.object('/questions/' + questionId).update(question);
  }

  delete(questionId) {
    return this.angularFireDatabase.object('/questions/' + questionId).remove();
  }
}