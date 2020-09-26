import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { DashBoardComponent } from './dash-board/dash-board.component';
import {AuthService as AuthGuard} from './service/auth.service';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { FavBookListComponent } from './fav-book-list/fav-book-list.component';
import { HomeComponent } from './home/home.component';
import { CategoriesComponent } from './categories/categories.component';
import { ContactComponent } from './contact/contact.component';
import {CommentComponent} from './comment/comment.component';
import {ViewcommentComponent} from './viewcomment/viewcomment.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'home',component:HomeComponent},
  {path:'search',component:SearchComponent},
  {path:'login',component:LoginComponent},
  {path:'registration',component:RegistrationComponent},
  {path:'dashboard',component:DashBoardComponent,canActivate:[AuthGuard]},
  {path:'edit',component:EditProfileComponent},
  {path:'fav',component:FavBookListComponent},
  {path:'categories', component: CategoriesComponent},
  {path:'contact', component: ContactComponent},
  {path:'comment', component:CommentComponent},
  {path:'viewCom',component:ViewcommentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{onSameUrlNavigation:'reload'}), CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
