import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

import { CourseService } from '../course-service/course.service';
import { Course } from '../course-service/course'

@Component({
  selector: 'course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {

  private courseId:number;
  private course:Course;
  private error:HttpErrorResponse;

  constructor(courseService:CourseService, route:ActivatedRoute) { 
    route.params.subscribe(params => this.courseId = params['courseId']);

    courseService.getCourseById(this.courseId).subscribe(
      (course) => this.course = course,
      (error) => this.error = error
    );
  }

  ngOnInit() {
  }

}
