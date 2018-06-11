package com.kbtran.srframe.converters;

import com.kbtran.srframe.domains.DomainCourse;
import com.kbtran.srframe.views.ViewCourse;

public interface ICourseConverter {

    DomainCourse viewToDomain(ViewCourse viewCourse);

    ViewCourse domainToView(DomainCourse domainCourse);

}
