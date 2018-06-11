package com.kbtran.srframe.manager;

import com.kbtran.srframe.views.ViewStudent;

import java.util.List;

public interface IStudentManager {

    List<ViewStudent> getAllStudents();

    ViewStudent getStudentById(Long studentId);

    ViewStudent createStudent(ViewStudent viewStudent);

    ViewStudent updateStudent(Long studentId, ViewStudent viewStudent);

    ViewStudent deleteStudent(Long studentId);


    //List<ViewStudent> getStudentByDate(Long startdate, Long endDate);
}
