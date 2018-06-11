package com.kbtran.srframe.converters.impl;

import com.kbtran.srframe.converters.ICourseGradeConverter;
import com.kbtran.srframe.converters.IStudentConverter;
import com.kbtran.srframe.domains.DomainStudent;
import com.kbtran.srframe.views.ViewStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentConverter implements IStudentConverter {

    @Autowired
    ICourseGradeConverter courseGradeConverter;

    @Override
    public DomainStudent viewToDomain(ViewStudent viewStudent) {
        DomainStudent domainStudent = new DomainStudent();
        domainStudent.setStudentId(viewStudent.getStudentId());
        domainStudent.setFirstName(viewStudent.getFirstName());
        domainStudent.setLastName(viewStudent.getLastName());
        domainStudent.setSchoolId(viewStudent.getSchoolId());
        domainStudent.setGradeLevelId(viewStudent.getGradeLevelId());
        domainStudent.setActive(viewStudent.getActive());
        if(viewStudent.getCourseGrades() != null) {
            domainStudent.setDomainCourseGrades(viewStudent.getCourseGrades().stream()
                    .map(courseGradeConverter::viewToDomain)
                    .collect(Collectors.toList()));
        }

        return domainStudent;
    }

    @Override
    public ViewStudent domainToView(DomainStudent domainStudent) {
        ViewStudent viewStudent = new ViewStudent();
        viewStudent.setStudentId(domainStudent.getStudentId());
        viewStudent.setFirstName(domainStudent.getFirstName());
        viewStudent.setLastName(domainStudent.getLastName());
        viewStudent.setSchoolId(domainStudent.getSchoolId());
        viewStudent.setGradeLevelId(domainStudent.getGradeLevelId());
        viewStudent.setActive(domainStudent.getActive());
        if(domainStudent.getDomainCourseGrades() != null) {
            viewStudent.setCourseGrades(domainStudent.getDomainCourseGrades().stream()
                    .map(courseGradeConverter::domainToView)
                    .collect(Collectors.toList()));
        }

        return viewStudent;
    }
}
