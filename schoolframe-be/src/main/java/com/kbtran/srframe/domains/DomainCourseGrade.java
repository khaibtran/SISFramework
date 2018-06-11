package com.kbtran.srframe.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_grade")
public class DomainCourseGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_SEQ")
    @SequenceGenerator(sequenceName = "COURSE_GRADE_SEQ", allocationSize = 1, name = "COURSE_SEQ")
    private Long courseGradeId;

    @Column(name = "course_id")
    private int courseId;


    @Column(name = "score")
    private int score;

//    @Column(name = "student_id")
//    private int studentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private DomainStudent domainStudent;

    public Long getCourseGradeId() {
        return courseGradeId;
    }

    public void setCourseGradeId(Long courseGradeID) {
        this.courseGradeId = courseGradeID;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }

    public DomainStudent getDomainStudent() {
        return domainStudent;
    }

    public void setDomainStudent(DomainStudent domainStudent) {
        this.domainStudent = domainStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainCourseGrade that = (DomainCourseGrade) o;
        return courseGradeId == that.courseGradeId &&
                courseId == that.courseId &&
                score == that.score &&
                Objects.equals(domainStudent, that.domainStudent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(courseGradeId, courseId, score, domainStudent);
    }
}
