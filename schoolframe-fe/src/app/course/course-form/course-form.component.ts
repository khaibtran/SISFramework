import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse} from '@angular/common/http';
import {
    Router,
    ActivatedRoute
 } from '@angular/router';

 import { CourseService } from '../course-service/course.service';
 import { Course } from '../course-service/course';

@Component({
  selector: 'course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent implements OnInit {

  private courseId:number;
  private course:Course;
  private courseService:CourseService;

  private error:HttpErrorResponse;
  private router:Router;

  constructor(courseService:CourseService, router:Router, route:ActivatedRoute) { 
    this.courseService = courseService;
    this.router = router;

    route.params.subscribe(params => this.courseId = params['courseId']);

    if(this.courseId) {
      this.courseService.getCourseById(this.courseId).subscribe(
        (course) => this.course = course,
        (error) => this.error = error
      );
    } else {
      this.course = new Course();
    }

  }

  submitCourse() {
    if(this.courseId) {
      this.courseService.updateCourse(this.courseId, this.course).subscribe(
        (course) => this.router.navigate(['courses', this.courseId]),
        (error) => this.error = error
      );
    } else {
      this.courseService.createCourse(this.course).subscribe(
        (course) => this.router.navigate(['courses']),
        (error) => this.error = error
      );
    }
  }

  ngOnInit() {
  }

}
