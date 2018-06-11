package com.kbtran.srframe.manager;

import com.kbtran.srframe.views.ViewCourse;

import java.util.List;

public interface ICoursesManager {

    List<ViewCourse> getAllCourses();

    ViewCourse getCourseById(Long courseId);

    ViewCourse createCourse(ViewCourse viewCourse);

    ViewCourse updateCourse(Long courseId, ViewCourse viewCourse);

    ViewCourse deleteCourse(Long courseId);
}
