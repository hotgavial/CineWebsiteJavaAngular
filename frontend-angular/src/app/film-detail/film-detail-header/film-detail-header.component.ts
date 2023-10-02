import { Component, Input, OnInit } from '@angular/core';
import { Movie } from '../../core/models/movie';
import { FilmService } from 'src/app/core/services/film.service';

@Component({
  selector: 'film-detail-header',
  templateUrl: 'film-detail-header.component.html',
  styleUrls: ['film-detail-header.component.scss']
})
export class FilmDetailHeader implements OnInit {

  posterLink: string = '';
  averageRating: number | undefined;

  constructor(private filmService: FilmService) { }

  @Input() movie: Movie;

  ngOnInit(): void {

    if (this.movie && this.movie.idMovie) {
      this.posterLink = `../../../assets/images/${this.movie.idMovie}-poster.jpg`;
      this.filmService.getMovieAverageRating(this.movie.idMovie)
        .subscribe(averageRating => this.averageRating = averageRating);
    }
  }

}
