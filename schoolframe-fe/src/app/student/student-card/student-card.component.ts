import { 
  Component, 
  OnInit,
  Input,
  EventEmitter,
  Output 
} from '@angular/core';

import { Student } from '../student-service/student';

@Component({
  selector: 'student-card',
  templateUrl: './student-card.component.html',
  styleUrls: ['./student-card.component.css']
})
export class StudentCardComponent implements OnInit {

  @Input()
  private student:Student;

  @Output()
  private studentDeleted: EventEmitter<Student>;

  constructor() { 
    this.studentDeleted = new EventEmitter<Student>();

  }

  deleteStudent() {
    this.studentDeleted.emit(this.student);
  }

  ngOnInit() {
  }

}
