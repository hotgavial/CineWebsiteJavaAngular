import { ActorMovie } from "./actor-movie";

export class Movie {
    idMovie!: number;
    title!: string;
    originalTitle!: string;
    year!: number;
    trailer?: string;
    cast!: ActorMovie[];

    constructor() {
        this.cast = [];
    }
}