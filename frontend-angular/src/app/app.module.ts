import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { FilmDetail } from './film-detail/film-detail.component';
import { AppComponent } from './app.component';
import { FilmDetailHeader } from './film-detail/film-detail-header/film-detail-header.component';
import { FilmTechnicalInfo } from './film-detail/film-detail-header/film-technical-info/film-technical-info.component';
import { SpectatorsGrade } from './film-detail/film-detail-header/spectators-grade/spectators-grade.comonent';
import { UserSpace } from './user-space/user-space.component';
import { Login } from './login/login.component';
import { UserGrade } from './film-detail/film-detail-header/user-grade/user-grade.component';

@NgModule({
  declarations: [
    AppComponent,
    FilmTechnicalInfo,
    SpectatorsGrade,
    UserGrade,
    FilmDetailHeader,
    FilmDetail,
    UserSpace,
    Login
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
