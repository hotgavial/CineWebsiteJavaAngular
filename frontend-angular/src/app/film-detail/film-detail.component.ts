import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { FilmService } from '../core/services/film.service';
import { Movie } from '../core/models/movie';

@Component({
  selector: 'film-detail',
  templateUrl: 'film-detail.component.html',
  styleUrls: ['film-detail.component.scss']
})
export class FilmDetail implements OnInit {

  movie: Movie | undefined;

  constructor(private router: ActivatedRoute, private filmService: FilmService) { }

  ngOnInit(): void {
    const filmId: string | null = this.router.snapshot.paramMap.get('id');
    if (filmId) {
      this.filmService.getMovieById(+filmId)
        .subscribe(movie => this.movie = movie);
    }

  }

}
