import { Component, OnInit } from '@angular/core';
import { User } from '../core/models/user';
import { AuthService } from '../core/services/auth.sercice';


@Component({
    selector: 'login',
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.scss']
})
export class Login {

    user: User = new User();
    error: boolean = false;

    constructor(private authService: AuthService) { }

    onSubmit() {
        this.authService.login(this.user).subscribe((token => {
            console.log(token);
            if (token !== undefined) {
                localStorage.setItem('token', token);
                console.log(this.user.pseudo);
                localStorage.setItem('username', this.user.pseudo);
            } else {
                this.error = true;
            }
        }
        ));
    }

}
