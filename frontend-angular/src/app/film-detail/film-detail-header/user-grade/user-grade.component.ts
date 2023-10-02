import { Component, Input, OnInit } from '@angular/core';
import { FilmService } from 'src/app/core/services/film.service';
import { Review } from 'src/app/core/models/review';

@Component({
    selector: 'user-grade',
    templateUrl: 'user-grade.component.html',
    styleUrls: ['user-grade.component.scss']
})

export class UserGrade implements OnInit {

    isHovered: boolean = false;
    hoveredIndex: number = 0;
    userReview: Review | undefined;


    constructor(private filmService: FilmService) { };


    @Input() movieId: number;

    ngOnInit(): void {
        if (this.movieId && localStorage.getItem("username") && localStorage.getItem("token")) {
            console.log(this.movieId);
            this.filmService.getUserGrade(this.movieId).subscribe(review => this.userReview = review);
        }
    }

    onMouseOver(index: number) {
        this.isHovered = true;
        this.hoveredIndex = index;
    }

    onMouseLeave() {
        this.isHovered = false;
    }


    determinateClassForStar(index: number) {
        if (this.isHovered) {
            return index <= this.hoveredIndex ? 'fa fa-star hovered' : 'fa fa-star'
        }
        console.log(this.userReview?.grade && index <= this.userReview.grade);
        return this.userReview?.grade && index <= this.userReview.grade ? 'fa fa-star checked' : 'fa fa-star'


    }


}
