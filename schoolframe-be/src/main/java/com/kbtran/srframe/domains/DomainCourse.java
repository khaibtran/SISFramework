package com.kbtran.srframe.domains;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class DomainCourse {

    @Id
    @Column(name = "course_id")
    private long courseId;

    @Column(name = "name")
    private String name;

    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "credits")
    private int credits;

    @Column(name = "active")
    private int active;


    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}

