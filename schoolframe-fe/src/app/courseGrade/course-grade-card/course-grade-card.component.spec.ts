import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseGradeCardComponent } from './course-grade-card.component';

describe('CourseGradeCardComponent', () => {
  let component: CourseGradeCardComponent;
  let fixture: ComponentFixture<CourseGradeCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseGradeCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseGradeCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
