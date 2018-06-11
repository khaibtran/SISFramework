import { CourseService } from '../course-service/course.service';
import { Course } from '../course-service/course';

import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  private courses:Course[];
  private courseService:CourseService;
  private error:HttpErrorResponse;

  constructor(courseService:CourseService) { 
    courseService.getAllCourses().subscribe(
      (courses) => this.courses = courses,
      (error) => this.error = error
    );

    this.courseService = courseService;
  }

  deleteCourseFromList(courseId:number) {
    const index:number = this.courses.findIndex((course) => course.courseId == courseId);
    this.courses.splice(index, 1);
  }

  deleteCourse(course:Course) {
    this.courseService.deleteCourse(course.courseId).subscribe(
      (course) => this.deleteCourseFromList(course.courseId),
      (error) => this.error = error
    );
  }

  ngOnInit() {
  }

}
