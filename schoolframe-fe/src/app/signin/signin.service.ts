import {
    AuthService,
    FacebookLoginProvider,
    GoogleLoginProvider
} from 'angular5-social-login';
import { Injectable } from '@angular/core';

@Injectable()
    export class SignInService {
    public email:string;
    private image:string;
    public isLoggedIn:boolean;


    constructor( private socialAuthService: AuthService ) {}

    public socialSignIn(socialPlatform : string) {
        let socialPlatformProvider;
        if(socialPlatform == "facebook"){
            socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
        }else if(socialPlatform == "google"){
            socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
        }
        
        this.socialAuthService.signIn(socialPlatformProvider).then(
            (userData) => {
            console.log(socialPlatform+" sign in data : " , userData);
            // Now sign-in with userData
            this.email = userData.email;
            this.image = userData.image;
            this.isLoggedIn = true;

            console.log(userData.email, userData.image);
            console.log(this.email, this.isLoggedIn);
                
            });
        }

        public getEmail():string {
            return this.email;
        }

        public getImage():string {
            return this.image;
        }

        public getIsLoggedIn():boolean {
            return this.isLoggedIn;
        }
}


