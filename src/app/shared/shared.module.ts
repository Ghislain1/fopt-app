import { AnsweredQuestion } from './models/answered-question';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomFormsModule } from 'ng2-validation';
import { FormsModule } from '@angular/forms';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from './services/user-service';
import { ChapterService } from './services/chapter.service';
import { QuestionService } from './services/question.service';
import { AnsweredQuestionService } from './services/answered-question.service';
import { AuthGuard } from './services/auth-guard.service';
import { AuthService } from './services/auth.service';
import { QuestionQuantityComponent } from './components/question-quantity/question-quantity.component';
import { QuestionCardComponent } from './components/question-card/question-card.component';



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
  declarations: [
    QuestionQuantityComponent,
    QuestionCardComponent // TODO_Ghislain: Compoent to display each question!!
  ],
  providers: [
    AuthService,
    AuthGuard,
    UserService,
    ChapterService,
    QuestionService,
    AnsweredQuestionService // Similary to --> ShoppingCartService,
    // OrderService
  ],
  exports: [
    QuestionCardComponent,
    QuestionQuantityComponent,
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
