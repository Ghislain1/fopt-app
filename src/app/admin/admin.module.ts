import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuestionFormComponent } from './components/question-form/question-form.component';
import { SharedModule } from '../shared/shared.module';
import { RouterModule } from '@angular/router';




@NgModule({
  imports: [
    SharedModule,
    //   RouterModule.forChild([
    //     {
    //       path: 'admin/questions/new',
    //       component: ProductFormComponent,
    //       canActivate: [AuthGuard, AdminAuthGuard]
    //     },
    //     {
    //       path: 'admin/products/:id',
    //       component: ProductFormComponent,
    //       canActivate: [AuthGuard, AdminAuthGuard]
    //     },
    //     {
    //       path: 'admin/products',
    //       component: AdminProductsComponent,
    //       canActivate: [AuthGuard, AdminAuthGuard]
    //     },
    //     {
    //       path: 'admin/orders',
    //       component: AdminOrdersComponent,
    //       canActivate: [AuthGuard, AdminAuthGuard]
    //     }
    //   ])
  ],
  declarations: [
    QuestionFormComponent,
    // AdminProductsComponent,
    // AdminOrdersComponent,
  ]
})
export class AdminModule { }
