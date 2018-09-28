import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuestionListComponent } from './components/question-list/question-list.component';
import { QuestionFilterComponent } from './components/question-list/question-filter/question-filter.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [QuestionListComponent, QuestionFilterComponent]
})
export class FoptModule { }
