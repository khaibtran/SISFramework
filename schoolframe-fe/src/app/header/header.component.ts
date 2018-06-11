import { Component, OnInit } from '@angular/core';
import {
  AuthService,
  FacebookLoginProvider,
  GoogleLoginProvider
} from 'angular5-social-login';

import { SignInService } from '../signin/signin.service';


@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private email:string;
  private image:string;
  private isLoggedIn:boolean;

  constructor( private socialAuthService: AuthService, signInService:SignInService ) {
    if(signInService.getIsLoggedIn())  {
      this.email = signInService.getEmail();
      this.image = signInService.getImage();
      this.isLoggedIn = signInService.getIsLoggedIn();
    }
    
  }
  

  ngOnInit() {
  }

}
