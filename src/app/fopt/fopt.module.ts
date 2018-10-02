import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuestionListComponent } from './components/question-list/question-list.component';
import { QuestionFilterComponent } from './components/question-list/question-filter/question-filter.component';
import { RouterModule } from '@angular/router';
import { AuthGuard } from '../shared/services/auth-guard.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild([
      {
        path: 'app-question-list',
        component: QuestionListComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'app-question-filter',
        component: QuestionFilterComponent,
        canActivate: [AuthGuard] //TODO-GHislain: AuthGuard check if you are the user,  AdminAuthGuard check if you are admin
      },

    ])
  ],
  declarations: [QuestionListComponent, QuestionFilterComponent],

})
export class FoptModule { }
