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
import { PostAddComponent } from './forum/post-add/post-add.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AuthGuard } from './auth/auth-guard.service';
import { TopicAddComponent } from './forum/topic-add/topic-add.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'forum', component: ForumComponent, canActivate: [AuthGuard] },
  { path: 'thread/:id', component: ThreadComponent, canActivate: [AuthGuard] },
  { path: 'thread/edit/:id', component: ThreadEditComponent, canActivate: [AuthGuard] },
  { path: 'thread-add', component: ThreadAddComponent, canActivate: [AuthGuard] },
  { path: 'post/edit/:id', component: PostEditComponent, canActivate: [AuthGuard] },
  { path: 'post-add/:id', component: PostAddComponent, canActivate: [AuthGuard] },
  { path: 'user', component: UserComponent, canActivate: [AuthGuard] },
  { path: 'add-topic', component: TopicAddComponent },
  { path: 'home', component: HomeComponent},
  { path: 'auth', component: AuthComponent},
  { path: 'faq', component: FaqComponent, canActivate: [AuthGuard] },
  { path: 'faq-edit', component: FaqEditComponent, canActivate: [AuthGuard]},
  { path: 'faq-edit/:id', component: FaqEditComponent, canActivate: [AuthGuard] },
  { path: 'sign-up', component: SignUpComponent},
  { path: 'contact-us', component: ContactUsComponent },
  { path: 'notification', component: NotificationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
