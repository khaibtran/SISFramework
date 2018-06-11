package com.kbtran.srframe.views;

public class ViewCourseGrade {

    private Long courseGradeId;

    private int courseId;

    private Long studentId;

    //private ViewStudent viewStudent;

    private int score;

    public Long getCourseGradeId() {
        return courseGradeId;
    }

    public void setCourseGradeId(Long courseGradeId) {
        this.courseGradeId = courseGradeId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

//    public ViewStudent getViewStudent() {
//        return viewStudent;
//    }
//
//    public void setViewStudent(ViewStudent viewStudent) {
//        this.viewStudent = viewStudent;
//    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
