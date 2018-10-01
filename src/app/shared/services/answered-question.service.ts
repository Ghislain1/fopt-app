import { Injectable } from '@angular/core';
import { Question } from '../models/question';
import { AngularFireDatabase } from 'angularfire2/database';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AnsweredQuestionService {
  constructor(private db: AngularFireDatabase) { }

  // async getAnsweredQ(): Promise<Observable<ShoppingAnsweredQ>> {
  //   let AnsweredQId = await this.getOrCreateAnsweredQId();
  //   return this.db.object('/shopping-AnsweredQs/' + AnsweredQId)
  //     .pipe(map(x => new ShoppingAnsweredQ(x.items)));
  // }

  async addToAnsweredQ(question: Question) {
    // this.updateItem(question, 1);
  }

  async removeFromAnsweredQ(question: Question) {
    //  this.updateItem(question, -1);
  }

  async clearAnsweredQ() {
    let AnsweredQId = await this.getOrCreateAnsweredQId();
    this.db.object('/shopping-AnsweredQs/' + AnsweredQId + '/items').remove();
  }


  private create() {
    return this.db.list('/shopping-AnsweredQs').push({
      dateCreated: new Date().getTime()
    });
  }

  private getItem(AnsweredQId: string, questionId: string) {
    return this.db.object('/shopping-AnsweredQs/' + AnsweredQId + '/items/' + questionId);
  }

  private async getOrCreateAnsweredQId(): Promise<string> {
    let AnsweredQId = localStorage.getItem('AnsweredQId');
    if (AnsweredQId) return AnsweredQId;

    let result = await this.create();
    localStorage.setItem('AnsweredQId', result.key);
    return result.key;
  }

  // private async updateItem(question: Question, change: number) {
  //   let AnsweredQId = await this.getOrCreateAnsweredQId();
  //   let item$ = this.getItem(AnsweredQId, question.$key);
  //   item$.take(1).subscribe(item => {
  //     let quantity = (item.quantity || 0) + change;
  //     if (quantity === 0) item$.remove();
  //     else item$.update({
  //       title: question.title,
  //       imageUrl: question.imageUrl,
  //       price: question.price,
  //       quantity: quantity
  //     });
  //   });
  // }
}