import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';
import { FaqComponent } from './faq/faq.component';
import { FaqEditComponent } from './faq/faq-edit/faq-edit.component';
import { UserComponent } from './user/user.component';
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'home', component: HomeComponent},
  { path: 'auth', component: AuthComponent},
  { path: 'faq', component: FaqComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    HomeComponent,
    FaqComponent,
    FaqEditComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
