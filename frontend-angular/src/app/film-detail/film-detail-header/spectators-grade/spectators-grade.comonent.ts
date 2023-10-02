import { Component, Input, OnInit } from '@angular/core';
import { FilmService } from 'src/app/core/services/film.service';

@Component({
    selector: 'spectators-grade',
    templateUrl: 'spectators-grade.component.html',
    styleUrls: ['spectators-grade.component.scss']
})

export class SpectatorsGrade implements OnInit {

    averageRating: number | undefined;


    constructor(private filmService: FilmService) { };


    @Input() movieId: number;

    ngOnInit(): void {
        if (this.movieId) {
            this.filmService.getMovieAverageRating(this.movieId)
                .subscribe(averageRating => this.averageRating = averageRating);
        }
    }

    getGradeColor(): string {
        if (this.averageRating !== undefined) {
            if (this.averageRating >= 7.0) {
                return 'greenyellow';
            } else if (this.averageRating >= 6.0) {
                return 'yellow';
            } else if (this.averageRating >= 5.0) {
                return 'orange';
            } else {
                return 'red';
            }
        } else {
            return 'gray';
        }
    }

    getBorderColor(): string {
        if (this.averageRating !== undefined) {
            if (this.averageRating >= 7.0) {
                return 'green 0.4rem solid';
            } else if (this.averageRating >= 6.0) {
                return 'khaki 0.4rem solid';
            } else if (this.averageRating >= 5.0) {
                return 'coral 0.4rem solid';
            } else {
                return 'firebrick 0.4rem solid';
            }
        } else {
            return 'gray 0.4rem solid';
        }
    }


}
