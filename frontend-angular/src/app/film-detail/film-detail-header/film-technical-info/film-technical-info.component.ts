import { Component, Input, OnInit } from '@angular/core';
import { Movie } from 'src/app/core/models/movie';

@Component({
    selector: 'film-technical-info',
    templateUrl: 'film-technical-info.component.html',
    styles: [
        `
    .film-detail {
      flex-direction: column;
    }
    `
    ]
})
export class FilmTechnicalInfo implements OnInit {

    directors: string = 'Aucun renseigné';
    actors: string = 'Aucun renseigné';
    composer: string = 'Aucun renseigné';


    @Input() movie: Movie;

    ngOnInit(): void {
        this.directors = this.getCastByJob('director');
        this.actors = this.getCastByJob('actor');
        this.composer = this.getCastByJob('composer');
    }

    private getCastByJob(job: string): string {
        const people: string[] = this.movie.cast
            .filter(cast => cast.job === job)
            .map(cast => `${cast.actor.firstName} ${cast.actor.lastName}`);

        return people.length !== 0 ? people.join(', ') : 'Aucun renseigné';
    }

}
