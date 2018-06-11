import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse} from '@angular/common/http';
import {
    Router,
    ActivatedRoute
 } from '@angular/router';

 import { CourseGradeService } from '../courseGrade-service/courseGrade.service';
 import { CourseGrade } from '../courseGrade-service/courseGrade';

@Component({
  selector: 'course-grade-form',
  templateUrl: './course-grade-form.component.html',
  styleUrls: ['./course-grade-form.component.css']
})
export class CourseGradeFormComponent implements OnInit {

  private courseGradeId:number;
  private courseGrade:CourseGrade;
  private courseGradeService:CourseGradeService;
  private error:HttpErrorResponse;
  private router:Router
  
  constructor(router:Router, route:ActivatedRoute, courseGradeService:CourseGradeService) { 
    this.router = router;
    this.courseGradeService = courseGradeService;

    route.params.subscribe(params => this.courseGradeId = params['courseGradeId']);

    if(this.courseGradeId) {
      this.courseGradeService.getCourseGradeById(this.courseGradeId).subscribe(
        (courseGrade) => this.courseGrade = courseGrade,
        (error) => this.error = error
      );
    } else {
      this.courseGrade = new CourseGrade();
    }

  }

  submitCourseGrade() {
    if(this.courseGradeId) {
      this.courseGradeService.updateCourseGrade(this.courseGradeId, this.courseGrade).subscribe(
        (courseGrade) => this.router.navigate(['courseGrades', this.courseGradeId]),
        (error) => this.error = error
      );
    } else {
      this.courseGradeService.createCourseGrade(this.courseGrade).subscribe(
        (courseGrade) => this.router.navigate(['courseGrades']),
        (error) => this.error = error
      );
    }
  }

  ngOnInit() {
  }

}
