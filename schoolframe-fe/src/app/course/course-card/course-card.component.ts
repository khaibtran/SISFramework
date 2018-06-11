import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

import { Course } from '../course-service/course';

@Component({
  selector: 'course-card',
  templateUrl: './course-card.component.html',
  styleUrls: ['./course-card.component.css']
})
export class CourseCardComponent implements OnInit {

  @Input()
  private course:Course;

  @Output()
  private courseDeleted:EventEmitter<Course>;

  constructor() { 
    this.courseDeleted = new EventEmitter<Course>();
  }

  deleteCourse() {
    this.courseDeleted.emit(this.course);
  }

  ngOnInit() {
  }

}
