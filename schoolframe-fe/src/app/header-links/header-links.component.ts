import { Component, OnInit } from '@angular/core';
import { 
  Router,
  RouterEvent,
  NavigationStart
} from '@angular/router';

@Component({
  selector: 'header-links',
  templateUrl: './header-links.component.html',
  styleUrls: ['./header-links.component.css']
})
export class HeaderLinksComponent implements OnInit {

  private router:Router;
  private currentRoute:string;

  constructor(router:Router) { this.router = router;}

  ngOnInit() {
  }

  private goToRoute(url:string): void {
    this.router.navigate([url]);

    //Highlight link header
    this.router.events
      .subscribe((event:RouterEvent) => {
        if (event instanceof NavigationStart) {
          this.setCurrentRoute(event.url);
        }
      })
  }

  private setCurrentRoute(url:string): void {
    if (url.indexOf('students') > -1) {
      this.currentRoute = 'students';
    }
    else if (url.indexOf('courses') > -1) {
      this.currentRoute = 'courses';
    }
    else if (url.indexOf('courseGrades') > -1) {
      this.currentRoute = 'courseGrades';
    }
    else {
      this.currentRoute = 'students';
    }
  }

}
