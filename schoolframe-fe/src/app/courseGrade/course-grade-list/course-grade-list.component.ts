import { CourseGradeService } from '../courseGrade-service/courseGrade.service';
import { CourseGrade } from '../courseGrade-service/courseGrade';

import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'course-grade-list',
  templateUrl: './course-grade-list.component.html',
  styleUrls: ['./course-grade-list.component.css']
})
export class CourseGradeListComponent implements OnInit {

  private courseGrades:CourseGrade[];
  private courseGradeService:CourseGradeService;
  private error:HttpErrorResponse;

  constructor(courseGradeService:CourseGradeService, ) { 
    courseGradeService.getAllCourseGrades().subscribe(
      (courseGrades) => this.courseGrades = courseGrades,
      (error) => this.error = error
    );

    this.courseGradeService = courseGradeService;
  }

  deleteCourseGradeFromList(courseGradeId:number) {
    const index:number = this.courseGrades.findIndex((courseGrade) => courseGrade.courseGradeId == courseGradeId);
    this.courseGrades.splice(index, 1);
  }

  deleteCourseGrade(courseGrade) {
    this.courseGradeService.deleteCourseGrade(courseGrade.courseGradeId).subscribe(
      (courseGrade) => {this.deleteCourseGradeFromList(courseGrade.courseGradeId)},
      (error) => this.error = error
    )
  }

  ngOnInit() {
  }

}
