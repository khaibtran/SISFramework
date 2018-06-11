import {Component, OnInit} from '@angular/core';
import {
    AuthService,
    FacebookLoginProvider,
    GoogleLoginProvider
} from 'angular5-social-login';
import { SignInService } from '../signin/signin.service';
 
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
 
 
export class SigninComponent {
 
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