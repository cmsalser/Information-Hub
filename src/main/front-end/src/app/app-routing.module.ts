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
import { EventsScheduleComponent } from './events-schedule/events-schedule.component';
import { AddEventComponent } from './events-schedule/add-event/add-event.component';
import { EventComponent } from './events-schedule/event/event.component';
import { EventEditComponent } from './events-schedule/event-edit/event-edit.component';
import { PostAddComponent } from './forum/post-add/post-add.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AuthGuard } from './guards/auth-guard.service';
import { AdminGuard } from './guards/admin-guard.service';
import { TopicAddComponent } from './forum/topic-add/topic-add.component';
import { InformationPageComponent } from './information-page/information-page.component';
import { AboutUsComponent } from './about-us/about-us.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'forum', component: ForumComponent, canActivate: [AuthGuard] },
  { path: 'thread/:id', component: ThreadComponent, canActivate: [AuthGuard] },
  { path: 'thread/edit/:id', component: ThreadEditComponent, canActivate: [AuthGuard] },
  { path: 'thread-add', component: ThreadAddComponent, canActivate: [AuthGuard] },
  { path: 'post/edit/:id', component: PostEditComponent, canActivate: [AdminGuard] },
  { path: 'post-add/:id', component: PostAddComponent, canActivate: [AuthGuard] },
  { path: 'user', component: UserComponent, canActivate: [AuthGuard] },
  { path: 'add-topic', component: TopicAddComponent, canActivate: [AdminGuard] },
  { path: 'home', component: HomeComponent},
  { path: 'auth', component: AuthComponent},
  { path: 'faq', component: FaqComponent, canActivate: [AuthGuard] },
  { path: 'faq-edit', component: FaqEditComponent, canActivate: [AdminGuard]},
  { path: 'faq-edit/:id', component: FaqEditComponent, canActivate: [AdminGuard] },
  { path: 'sign-up', component: SignUpComponent},
  { path: 'schedule', component: EventsScheduleComponent, canActivate: [AuthGuard]},
  { path: 'add-event', component: AddEventComponent, canActivate: [AdminGuard] },
  { path: 'event', component: EventComponent, canActivate: [AuthGuard]},
  { path: 'event-edit', component: EventEditComponent, canActivate: [AdminGuard] },
  { path: 'contact-us', component: ContactUsComponent },
  { path: 'notification', component: NotificationComponent, canActivate: [AuthGuard] },
  { path: 'information', component: InformationPageComponent },
  { path: 'about-us', component: AboutUsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
