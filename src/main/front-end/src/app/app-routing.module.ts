import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';
import { FaqComponent } from './faq/faq.component';
import { UserComponent } from "./user/user.component";
import { FaqEditComponent } from './faq/faq-edit/faq-edit.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'user', component: UserComponent },
  { path: 'home', component: HomeComponent},
  { path: 'auth', component: AuthComponent},
  { path: 'faq', component: FaqComponent},
  { path: 'faq-edit', component: FaqEditComponent},
  { path: 'faq-edit/:id', component: FaqEditComponent},
  { path: 'sign-up', component: SignUpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
