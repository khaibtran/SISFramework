package com.kbtran.srframe.views;

import java.util.List;

public class ViewStudent {

    private long studentId;

    private String firstName;

    private  String lastName;

    private int schoolId;

    private int gradeLevelId;

    private int active;

    public List<ViewCourseGrade> courseGrades;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(int gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<ViewCourseGrade> getCourseGrades() {
        return courseGrades;
    }

    public void setCourseGrades(List<ViewCourseGrade> courseGrades) {
        this.courseGrades = courseGrades;
    }
}
