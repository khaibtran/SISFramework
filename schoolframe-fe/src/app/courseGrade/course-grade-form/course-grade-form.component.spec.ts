import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseGradeFormComponent } from './course-grade-form.component';

describe('CourseGradeFormComponent', () => {
  let component: CourseGradeFormComponent;
  let fixture: ComponentFixture<CourseGradeFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseGradeFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseGradeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
