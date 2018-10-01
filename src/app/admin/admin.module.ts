import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuestionFormComponent } from './components/question-form/question-form.component';
import { SharedModule } from '../shared/shared.module';
import { RouterModule } from '@angular/router';

import { AuthGuard } from '../shared/services/auth-guard.service';
import { AdminAuthGuard } from './services/admin-auth-guard.service';
import { AdminQuestionListComponent } from './components/admin-question-list/admin-question-list.component';




@NgModule({
  imports: [
    SharedModule,
    RouterModule.forChild([
      {
        path: 'admin/questions/new',
        component: QuestionFormComponent,
        canActivate: [AuthGuard, AdminAuthGuard]
      },

      //     {
      //       path: 'admin/products/:id',
      //       component: ProductFormComponent,
      //       canActivate: [AuthGuard, AdminAuthGuard]
      //     },
      {
        path: 'admin/question/lists',
        component: AdminQuestionListComponent,
        canActivate: [AuthGuard, AdminAuthGuard] //TODO-GHislain: AuthGuard check if you are the user,  AdminAuthGuard checi if you are admin
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
