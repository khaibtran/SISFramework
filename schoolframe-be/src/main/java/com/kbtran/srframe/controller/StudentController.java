package com.kbtran.srframe.controller;

import com.kbtran.srframe.manager.impl.StudentManager;
import com.kbtran.srframe.views.ViewStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentManager studentManager;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewStudent>> getAllStudents() {
        return new ResponseEntity<>(studentManager.getAllStudents(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{studentId}",method = RequestMethod.GET)
    ResponseEntity<ViewStudent> getStudent(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentManager.getStudentById(studentId), HttpStatus.OK);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    ResponseEntity<ViewStudent> createStudent(@RequestBody ViewStudent viewStudent) {
        return new ResponseEntity<>(studentManager.createStudent(viewStudent), HttpStatus.OK);
    }

    @RequestMapping(value = "/{studentId}",method = RequestMethod.PUT)
    ResponseEntity<ViewStudent> updateStudent(@PathVariable Long studentId, @RequestBody ViewStudent viewStudent) {
        return new ResponseEntity<>(studentManager.updateStudent(studentId, viewStudent), HttpStatus.OK);
    }

    @RequestMapping(value = "/{studentId}",method = RequestMethod.DELETE)
    ResponseEntity<ViewStudent> deleteStudent(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentManager.deleteStudent(studentId), HttpStatus.OK);
    }

}
