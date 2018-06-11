package com.kbtran.srframe.converters.impl;

import com.kbtran.srframe.accessors.ICourseGradeAccessor;
import com.kbtran.srframe.accessors.IStudentAccessor;
import com.kbtran.srframe.converters.ICourseGradeConverter;
import com.kbtran.srframe.domains.DomainCourseGrade;
import com.kbtran.srframe.domains.DomainStudent;
import com.kbtran.srframe.views.ViewCourseGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseGradeConverter implements ICourseGradeConverter {

    @Autowired
    IStudentAccessor studentAccessor;

    @Override
    public DomainCourseGrade viewToDomain(ViewCourseGrade viewCourseGrade) {
        DomainCourseGrade domainCourseGrade = new DomainCourseGrade();
        domainCourseGrade.setCourseGradeId(viewCourseGrade.getCourseGradeId());
        domainCourseGrade.setCourseId(viewCourseGrade.getCourseId());
        DomainStudent domainStudent = studentAccessor.getOne(viewCourseGrade.getStudentId());
        domainCourseGrade.setDomainStudent(domainStudent);
        //domainCourseGrade.setStudentId(viewCourseGrade.getStudentId());
        domainCourseGrade.setScore(viewCourseGrade.getScore());

        return domainCourseGrade;
    }

    @Override
    public ViewCourseGrade domainToView(DomainCourseGrade domainCourseGrade) {
        ViewCourseGrade viewCourseGrade = new ViewCourseGrade();
        viewCourseGrade.setCourseGradeId(domainCourseGrade.getCourseGradeId());
        viewCourseGrade.setCourseId(domainCourseGrade.getCourseId());
        viewCourseGrade.setStudentId(domainCourseGrade.getDomainStudent().getStudentId());
        //viewCourseGrade.setStudentId(domainCourseGrade.getStudentId());
        viewCourseGrade.setScore(domainCourseGrade.getScore());

        return viewCourseGrade;
    }
}
