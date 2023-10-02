import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of, map } from 'rxjs';
import { User } from '../models/user';

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    constructor(private http: HttpClient) { }

    login(user: User): Observable<string | undefined> {
        return this.http.post(`http://localhost:8080/login`, user, { responseType: 'text' }).pipe(
            catchError((error) => this.handleError(error, undefined))
        );
    }

    isLoggedIn(): Observable<boolean> {
        return this.http.post(`http://localhost:8080/authorization-check`, { pseudo: localStorage.getItem('username'), token: localStorage.getItem('token') }).pipe(
            map(response => true),
            catchError(error => {
                console.error('Erreur lors de la vérification de la connexion:', error);
                return of(false);
            })
        );
    }

    private handleError(error: Error, errorValue: any) {
        console.error(error);
        return of(errorValue);
    }

}