import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

import { CourseGradeService } from '../courseGrade-service/courseGrade.service';
import { CourseGrade } from '../courseGrade-service/courseGrade';

@Component({
  selector: 'course-grade-details',
  templateUrl: './course-grade-details.component.html',
  styleUrls: ['./course-grade-details.component.css']
})
export class CourseGradeDetailsComponent implements OnInit {

  private courseGradeId:number;
  private courseGrade:CourseGrade;
  private error:HttpErrorResponse;

  constructor(courseGradeService:CourseGradeService, route:ActivatedRoute) { 
    route.params.subscribe(
      (params) => this.courseGradeId = params['courseGradeId']
    );

    courseGradeService.getCourseGradeById(this.courseGradeId).subscribe(
      (courseGrade) => this.courseGrade = courseGrade,
      (error) => this.error = error
    );
  }

  ngOnInit() {
  }

}
