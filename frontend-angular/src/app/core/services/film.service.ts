import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { Movie } from '../models/movie';
import { Review } from '../models/review';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  constructor(private http: HttpClient) { }

  getMovieById(movieId: number): Observable<Movie | undefined> {
    return this.http.get(`http://localhost:8080/movie/${movieId}`).pipe(
      catchError((error) => this.handleError(error, undefined))
    );
  }

  getMovieAverageRating(movieId: number): Observable<number | undefined> {
    return this.http.get(`http://localhost:8080/review/average/${movieId}`).pipe(
      catchError((error) => this.handleError(error, undefined))
    );
  }

  getUserGrade(idMovie: number,): Observable<Review | undefined> {
    const pseudo = localStorage.getItem('username');
    const token = localStorage.getItem('token');

    const params = new HttpParams()
      .set('pseudo', pseudo || '')
      .set('token', token || '');

    return this.http.get(`http://localhost:8080/review/get-user-review/${idMovie}`, { params }).pipe(
      catchError((error) => this.handleError(error, undefined))
    );
  }

  private handleError(error: Error, errorValue: any) {
    console.error(error);
    return of(errorValue);
  }
}
