import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FilmDetail } from './film-detail/film-detail.component';
import { UserSpace } from './user-space/user-space.component';
import { AuthGuard } from './auth.guard';
import { Login } from './login/login.component';

const routes: Routes = [
  { path: 'film-detail/:id', component: FilmDetail },
  { path: 'user-space', component: UserSpace, canActivate: [AuthGuard] },
  { path: 'login', component: Login }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
