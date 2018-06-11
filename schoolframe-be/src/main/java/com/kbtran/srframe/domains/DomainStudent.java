package com.kbtran.srframe.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class DomainStudent {

    @Id
    @Column(name = "student_id")
    private long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "grade_level_id")
    private int gradeLevelId;

    @Column(name = "active")
    private int active;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "domainStudent")
    private List<DomainCourseGrade> domainCourseGrades = new ArrayList<>();


//    @Column(name = "from_Date")
//    private long fromDate;
//
//    @Column(name = "thru_Date")
//    private long thruDate;

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

    public List<DomainCourseGrade> getDomainCourseGrades() {
        return domainCourseGrades;
    }

    public void setDomainCourseGrades(List<DomainCourseGrade> domainCourseGrades) {
        this.domainCourseGrades = domainCourseGrades;
    }

    //    public long getFromDate() {
//        return fromDate;
//    }
//
//    public void setFromDate(long fromDate) {
//        this.fromDate = fromDate;
//    }
//
//    public long getThruDate() {
//        return thruDate;
//    }
//
//    public void setThruDate(long thruDate) {
//        this.thruDate = thruDate;
//    }
}
