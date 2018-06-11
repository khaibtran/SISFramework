package com.kbtran.srframe.controller;

import com.kbtran.srframe.manager.impl.CourseGradeManager;
import com.kbtran.srframe.views.ViewCourseGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coursegrade")
public class CourseGradeController {

    @Autowired
    private CourseGradeManager courseGradeManager;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewCourseGrade>> getAllCourseGrades() {
        return new ResponseEntity<>(courseGradeManager.getAllCourseGrades(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{courseGradeId}",method = RequestMethod.GET)
    ResponseEntity<ViewCourseGrade> getCourseGrade(@PathVariable Long courseGradeId) {
        return new ResponseEntity<>(courseGradeManager.getCourseGradeById(courseGradeId), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewCourseGrade> createCourseGrade(@RequestBody ViewCourseGrade viewCourseGrade) {
        return new ResponseEntity<>(courseGradeManager.createCourseGrade(viewCourseGrade), HttpStatus.OK);
    }

    @RequestMapping(value = "/{courseGradeId}", method = RequestMethod.PUT)
    ResponseEntity<ViewCourseGrade> updateCourseGrade(@PathVariable Long courseGradeId, @RequestBody ViewCourseGrade viewCourseGrade) {
        return new ResponseEntity<>(courseGradeManager.updateCourseGrade(courseGradeId, viewCourseGrade), HttpStatus.OK);
    }

    @RequestMapping(value= "/{courseGradeId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewCourseGrade> deleteCourseGrade(@PathVariable Long courseGradeId) {
        return new ResponseEntity<>(courseGradeManager.deleteCourseGrade(courseGradeId), HttpStatus.OK);
    }
}
