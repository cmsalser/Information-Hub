import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';
import { FaqComponent } from './faq/faq.component';
import { UserComponent } from './user/user.component';
import { FaqEditComponent } from './faq/faq-edit/faq-edit.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ForumComponent } from './forum/forum.component';
import { ThreadComponent } from './forum/thread/thread.component';
import { ThreadEditComponent } from './forum/thread-edit/thread-edit.component';
import { PostEditComponent } from './forum/post-edit/post-edit.component';
import { ThreadAddComponent } from './forum/thread-add/thread-add.component';
import {UserService} from "./user/user.service";
import { NotificationComponent } from './notification/notification.component';

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
    ThreadAddComponent,
    NotificationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
 // exports: [
  //  SignUpComponent
//  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
