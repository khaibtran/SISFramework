import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Chart } from 'angular-highcharts';

import { StudentService } from '../student-service/student.service';
import { Student } from '../student-service/student';
import { CourseGrade } from '../../courseGrade/courseGrade-service/courseGrade';

@Component({
  selector: 'student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  private studentId:number;
  private student:Student;
  private scores:number[] = [];
  private error:HttpErrorResponse;
  private chart:Chart;

  constructor(route:ActivatedRoute, studentService:StudentService) { 
    route.params.subscribe(
      params => {this.studentId = params['studentId']}
    );

    studentService.getStudentById(this.studentId).subscribe(
      student => {this.student = student;
                  for(let grades of this.student.courseGrades ) {
                    this.scores.push(grades.score);
                  }
    },
      error => {this.error = error}
    );

    
       

  }

  ngOnInit() {
    // for(let grades of this.student.courseGrades ) {
    //   this.scores.push(grades.score);
    // }

    this.chart = new Chart({
      chart: {
        type: 'line'
      },
      title: {
        text: 'Scores'
      },
      credits: {
        enabled: false
      },
      series: [{
        name: 'Scores',
        data: this.scores
      }]
    });
  }

}
