import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse} from '@angular/common/http';
import {
    Router,
    ActivatedRoute
 } from '@angular/router';

 import { StudentService } from '../student-service/student.service';
 import { Student } from '../student-service/student';

@Component({
  selector: 'student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {

  private studentId:number;
  private student:Student;
  private studentService:StudentService;

  private error:HttpErrorResponse;
  private router:Router;

  constructor(router:Router, route:ActivatedRoute, studentService:StudentService) { 
    this.router = router;
    this.studentService = studentService;

    route.params.subscribe(params => this.studentId = params['studentId']);

    if(this.studentId) {
      studentService.getStudentById(this.studentId).subscribe(
        (student) => this.student = student,
        (error) => this.error = error
      );
    } else {
      this.student = new Student();
    }
  }

  submitStudent() {
    if(this.studentId) {
      this.studentService.updateStudent(this.studentId, this.student).subscribe(
        (student) => this.router.navigate(['students', this.studentId]),
        (error) => this.error = error
      );
    } else {
      this.studentService.createStudent(this.student).subscribe(
        (student) => this.router.navigate(['students']),
        (error) => this.error = error
      )
    }
  }

  ngOnInit() {
  }

}
