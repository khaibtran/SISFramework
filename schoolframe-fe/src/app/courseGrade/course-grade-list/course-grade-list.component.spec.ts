import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseGradeListComponent } from './course-grade-list.component';

describe('CourseGradeListComponent', () => {
  let component: CourseGradeListComponent;
  let fixture: ComponentFixture<CourseGradeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseGradeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseGradeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
