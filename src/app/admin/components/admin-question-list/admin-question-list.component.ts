import { Component, OnInit, OnDestroy } from '@angular/core';
import { Question } from '../../../shared/models/question';
import { Subscription } from 'rxjs';
import { DataTable } from "angular-6-datatable";
// import { DataTableResource } from 'angular-6-data-table'; // TODO-Ghislain: why this ? we know a better table api lib!!
import { QuestionService } from '../../../shared/services/question.service';

@Component({
  selector: 'app-admin-question-list',
  templateUrl: './admin-question-list.component.html',
  styleUrls: ['./admin-question-list.component.css']
})
export class AdminQuestionListComponent implements OnInit, OnDestroy {

  questions: Question[];
  itemCount: number;
  subscription: Subscription;
  //tableResource: DataTable<Question>;
  items: Question[] = [];


  constructor(private QuestionService: QuestionService) {

    this.itemCount = 10;
    this.subscription = this.QuestionService.getAll()
      .subscribe(questions => {
        this.questions = questions as Question[];
        // this.initializeTable(this.questions);
      });
  }

  // private initializeTable(Questions: Question[]) {
  //   this.tableResource = new DataTableResource(Questions);
  //   this.tableResource.query({ offset: 0 })
  //     .then(items => this.items = items);
  //   this.tableResource.count()
  //     .then(count => this.itemCount = count);
  // }

  // reloadItems(params) {
  //   if (!this.tableResource) return;

  //   this.tableResource.query(params)
  //     .then(items => this.items = items);
  // }

  // filter(query: string) {
  //   let filteredQuestions = (query) ?
  //     this.questions.filter(p => p.title.toLowerCase().includes(query.toLowerCase())) :
  //     this.questions;

  //   this.initializeTable(filteredQuestions);
  // }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  ngOnInit() {
  }

}