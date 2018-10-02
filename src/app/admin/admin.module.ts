import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuestionFormComponent } from './components/question-form/question-form.component';
import { SharedModule } from '../shared/shared.module';
import { RouterModule } from '@angular/router';

import { AuthGuard } from '../shared/services/auth-guard.service';
import { AdminAuthGuard } from './services/admin-auth-guard.service';
import { AdminQuestionListComponent } from './components/admin-question-list/admin-question-list.component';


// TODO_GHislain: Best pratce all Component soll mit    canActivate: [AuthGuard, AdminAuthGuard] gekennzeichen werden!! why?

@NgModule({
  imports: [
    SharedModule,
    RouterModule.forChild([
      {
        path: 'admin/questions/new',
        component: QuestionFormComponent,
        canActivate: [AuthGuard, AdminAuthGuard]
      },
      {
        path: 'app-admin-question-list',
        component: AdminQuestionListComponent,
        canActivate: [AuthGuard, AdminAuthGuard] //TODO-GHislain: AuthGuard check if you are the user,  AdminAuthGuard check if you are admin
      },

    ])
  ],

  declarations: [
    QuestionFormComponent,

    AdminQuestionListComponent,
    // AdminProductsComponent,
    // AdminOrdersComponent,
  ]
})
export class AdminModule { }
