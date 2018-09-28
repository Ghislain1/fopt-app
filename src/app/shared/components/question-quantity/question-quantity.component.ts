import { Component, OnInit, Input } from '@angular/core';
import { Question } from '../../models/question';
import { AnsweredQuestionService } from '../../services/answered-question.service';

@Component({
  selector: 'app-question-quantity',
  templateUrl: './question-quantity.component.html',
  styleUrls: ['./question-quantity.component.css']
})
export class QuestionQuantityComponent {

  @Input('question') question: Question;
  @Input('answered-question') AnsweredQuestion;


  constructor(private answeredQuestionService: AnsweredQuestionService) { }

  addToAnsweredQ() {
    this.answeredQuestionService.addToAnsweredQ(this.question);
  }

  //TODO_GHislain: only the admi can do that???? should be removed from here...
  removedFromAnsweredQ() {
    this.answeredQuestionService.addToAnsweredQ(this.question);
  }

}
