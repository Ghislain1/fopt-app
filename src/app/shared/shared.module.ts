import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomFormsModule } from 'ng2-validation';
import { FormsModule } from '@angular/forms';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from './services/user-service';



@NgModule({
  imports: [
    CommonModule,
    FormsModule, //TODO:GHislain why?
    CustomFormsModule,
    //DataTableModule,
    AngularFireDatabaseModule,//TODO-Ghislain: for what? and why?
    AngularFireAuthModule,
    NgbModule.forRoot(),//TODO_Ghislain: can you explain why this here?
  ],
  declarations: [],
  providers: [
    //AuthService,
    //AuthGuard,
    UserService,
    //CategoryService,
    // ProductService,
    // ShoppingCartService,
    // OrderService
  ],
  exports: [
    // ProductCardComponent,
    //ProductQuantityComponent,
    CommonModule,
    FormsModule,
    CustomFormsModule,
    //DataTableModule,
    AngularFireDatabaseModule,//TODO-Ghislain: for what? 
    AngularFireAuthModule,
    NgbModule.forRoot().ngModule,//TODO_Ghislain: can you explain why this here?
  ],
})
export class SharedModule { }
