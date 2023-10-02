import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { AuthService } from './core/services/auth.sercice';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) { }

  canActivate(): Observable<boolean> {
    console.log('ici')
    // localStorage.getItem("pseudo") && localStorage.getItem("token")
    console.log(localStorage.getItem("token"))
    if (localStorage.getItem("username") && localStorage.getItem("token")) {
      console.log('pas ici')
      return this.authService.isLoggedIn();
    }
    return of(false);
  }
}
