import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';
import { FaqComponent } from './faq/faq.component';
import { UserComponent } from "./user/user.component";
import { FaqEditComponent } from './faq/faq-edit/faq-edit.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { NotificationComponent } from './notification/notification.component';

import { ForumComponent } from './forum/forum.component';
import { ThreadComponent } from './forum/thread/thread.component';
import { ThreadEditComponent } from './forum/thread-edit/thread-edit.component';
import { PostEditComponent } from './forum/post-edit/post-edit.component';
import { ThreadAddComponent } from './forum/thread-add/thread-add.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'forum', component: ForumComponent },
  { path: 'thread/:id', component: ThreadComponent },
  { path: 'thread/edit/:id', component: ThreadEditComponent },
  { path: 'thread-add', component: ThreadAddComponent },
  { path: 'post/edit/:id', component: PostEditComponent },
  { path: 'user', component: UserComponent },
  { path: 'home', component: HomeComponent},
  { path: 'auth', component: AuthComponent},
  { path: 'faq', component: FaqComponent},
  { path: 'faq-edit', component: FaqEditComponent},
  { path: 'faq-edit/:id', component: FaqEditComponent},
  { path: 'notification', component: NotificationComponent},
  { path: 'sign-up', component: SignUpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
