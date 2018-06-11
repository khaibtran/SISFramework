import { Component } from '@angular/core';
import {
    AuthService,
    FacebookLoginProvider,
    GoogleLoginProvider
  } from 'angular5-social-login';
  
import { SignInService } from './signin/signin.service';
  
@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent{ 

  private email:string;
  private image:string;
  private isLoggedIn:boolean;
  private signInService:SignInService

  constructor( private socialAuthService: AuthService, signInService:SignInService ) {
    this.signInService = signInService;

    this.email = this.signInService.getEmail();
    this.image = this.signInService.getImage();
    this.isLoggedIn = this.signInService.getIsLoggedIn();
    
  }
}