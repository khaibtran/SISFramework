import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

import { SignInService } from '../signin/signin.service'; 

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private signInService:SignInService, private router:Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if(this.signInService.isLoggedIn) {
      console.log(this.signInService.isLoggedIn);
      return true;}
    else{
      console.log(this.signInService.isLoggedIn);
      this.router.navigate(['signin']);}

  }
}
