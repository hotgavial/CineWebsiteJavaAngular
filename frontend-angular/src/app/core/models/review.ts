import { Movie } from "./movie";
import { User } from "./user";

export class Review {
    idReview: number;
    movie: Movie;
    user: User;
    review?: string;
    grade: number;
}