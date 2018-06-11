package com.kbtran.srframe.manager;

import com.kbtran.srframe.views.ViewCourseGrade;

import java.util.List;

public interface ICourseGradeManager {
    List<ViewCourseGrade> getAllCourseGrades();

    ViewCourseGrade getCourseGradeById(Long courseGradeId);

    ViewCourseGrade createCourseGrade(ViewCourseGrade viewCourseGrade);

    ViewCourseGrade updateCourseGrade(Long courseGradeId, ViewCourseGrade viewCourseGrade);

    ViewCourseGrade deleteCourseGrade(Long courseGradeId);
}
