package com.kbtran.srframe.controller;

import com.kbtran.srframe.manager.impl.CourseManager;
import com.kbtran.srframe.views.ViewCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseManager courseManager;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewCourse>> getAllCourses() {
        return new ResponseEntity<>(courseManager.getAllCourses(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{courseId}",method = RequestMethod.GET)
    ResponseEntity<ViewCourse> getCourse(@PathVariable long courseId) {
        return new ResponseEntity<>(courseManager.getCourseById(courseId), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewCourse> createCourse(@RequestBody ViewCourse viewCourse) {
        return new ResponseEntity<>(courseManager.createCourse(viewCourse), HttpStatus.OK);
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.PUT)
    ResponseEntity<ViewCourse> updateCourse(@PathVariable long courseId, @RequestBody ViewCourse viewCourse) {
        return new ResponseEntity<>(courseManager.updateCourse(courseId, viewCourse), HttpStatus.OK);
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewCourse> deleteCourse(@PathVariable long courseId) {
        return new ResponseEntity<>(courseManager.deleteCourse(courseId), HttpStatus.OK);
    }

}
