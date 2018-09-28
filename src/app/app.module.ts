import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { AdminModule } from './admin/admin.module';
import { FoptModule } from './fopt/fopt.module';
import { CoreModule } from './core/core.module';
import { AngularFireModule } from '@angular/fire';
import { environment } from '../environments/environment';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './core/components/login/login.component';
import { QuestionListComponent } from './fopt/components/question-list/question-list.component';




@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    SharedModule,
    AdminModule,
    FoptModule,
    CoreModule,
    AngularFireModule.initializeApp(environment.firebase), //TODO_Ghislain: why here?
    RouterModule.forRoot([
      { path: '', component: QuestionListComponent },
      { path: 'login', component: LoginComponent },
    ])
  ],
  providers: [
    //AdminAuthGuard,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
