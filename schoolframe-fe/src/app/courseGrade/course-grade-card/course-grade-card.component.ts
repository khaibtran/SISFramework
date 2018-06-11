import { CourseGrade } from '../courseGrade-service/courseGrade';

import { 
  Component, 
  OnInit,
  Input,
  EventEmitter,
  Output 
} from '@angular/core';

@Component({
  selector: 'course-grade-card',
  templateUrl: './course-grade-card.component.html',
  styleUrls: ['./course-grade-card.component.css']
})
export class CourseGradeCardComponent implements OnInit {

  @Input()
  private courseGrade:CourseGrade;

  @Output()
  private courseGradeDeleted: EventEmitter<CourseGrade>;

  constructor() { 
    this.courseGradeDeleted = new EventEmitter<CourseGrade>();
  }

  deleteCourseGrade() {
    this.courseGradeDeleted.emit(this.courseGrade);
  }

  ngOnInit() {
  }

}
