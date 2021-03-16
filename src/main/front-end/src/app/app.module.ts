import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';
import { FaqComponent } from './faq/faq.component';
import { UserComponent } from './user/user.component';
import {AuthService} from "./auth/auth.service";
import { FaqEditComponent } from './faq/faq-edit/faq-edit.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ForumComponent } from './forum/forum.component';
import { ThreadComponent } from './forum/thread/thread.component';
import { ThreadEditComponent } from './forum/thread-edit/thread-edit.component';
import { PostEditComponent } from './forum/post-edit/post-edit.component';
import { ThreadAddComponent } from './forum/thread-add/thread-add.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    HomeComponent,
    FaqComponent,
    UserComponent,
    FaqEditComponent,
    SignUpComponent,
    UserComponent,
    ForumComponent,
    ThreadComponent,
    ThreadEditComponent,
    PostEditComponent,
    ThreadAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
 // exports: [
  //  SignUpComponent
//  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
