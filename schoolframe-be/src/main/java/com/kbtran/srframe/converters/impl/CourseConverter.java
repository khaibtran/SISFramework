package com.kbtran.srframe.converters.impl;

import com.kbtran.srframe.converters.ICourseConverter;
import com.kbtran.srframe.domains.DomainCourse;
import com.kbtran.srframe.views.ViewCourse;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements ICourseConverter {
    @Override
    public DomainCourse viewToDomain(ViewCourse viewCourse) {
        DomainCourse domainCourse = new DomainCourse();
        domainCourse.setCourseId(viewCourse.getCourseId());
        domainCourse.setName(viewCourse.getName());
        domainCourse.setSchoolId(viewCourse.getSchoolId());
        domainCourse.setCredits(viewCourse.getCredits());
        domainCourse.setActive(viewCourse.getActive());

        return domainCourse;
    }

    @Override
    public ViewCourse domainToView(DomainCourse domainCourse) {
        ViewCourse viewCourse = new ViewCourse();
        viewCourse.setCourseId(domainCourse.getCourseId());
        viewCourse.setName(domainCourse.getName());
        viewCourse.setSchoolId(domainCourse.getSchoolId());
        viewCourse.setCredits(domainCourse.getCredits());
        viewCourse.setActive(domainCourse.getActive());

        return viewCourse;
    }
}
