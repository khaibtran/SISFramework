import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseGradeDetailsComponent } from './course-grade-details.component';

describe('CourseGradeDetailsComponent', () => {
  let component: CourseGradeDetailsComponent;
  let fixture: ComponentFixture<CourseGradeDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseGradeDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseGradeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
