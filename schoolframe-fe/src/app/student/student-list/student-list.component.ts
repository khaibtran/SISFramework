import { StudentService} from '../student-service/student.service';
import { Student } from '../student-service/student';

import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  private students:Student[];
  private error: HttpErrorResponse;
  private studentService:StudentService;

  constructor(studentService:StudentService) { 
    studentService.getAllStudents().subscribe(
      (students) => this.students = students,
      (error) => this.error = error
    );
    
    this.studentService = studentService;
  }

  deleteStudentFromList(studentId:number) {
    const index:number = this.students.findIndex((student) => student.studentId == studentId);
    this.students.splice(index, 1);
  }

  deleteStudent(student) {
    this.studentService.deleteStudent(student.studentId).subscribe(
      (student) => {this.deleteStudentFromList(student.studentId)},
      (error) => {this.error = error}
    )
  }

  ngOnInit() {
  }

}
