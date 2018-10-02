import { AnsweredQuestion } from './../../models/answered-question';
import { Component, OnInit, Input } from '@angular/core';
import { AnsweredQuestionService } from '../../services/answered-question.service';
import { Question } from '../../models/question';

@Component({
  selector: 'app-question-card',
  templateUrl: './question-card.component.html',
  styleUrls: ['./question-card.component.css']
})
export class QuestionCardComponent implements OnInit {




  @Input('question') question: Question;
  @Input('show-actions') showActions = true;
  @Input('answered-question') answeredQuestion: AnsweredQuestion;

  constructor(private answeredQuestionService: AnsweredQuestionService) { }

  addToCart() {
    this.answeredQuestionService.addToAnsweredQ(this.question);
  }

  ngOnInit(): void {
    this.log(' ngOnInit()');
  }

  private log(value: any): void {
    console.log(JSON.stringify(value, null, 3));
  }
}