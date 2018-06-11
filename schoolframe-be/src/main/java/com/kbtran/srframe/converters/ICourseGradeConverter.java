package com.kbtran.srframe.converters;

import com.kbtran.srframe.domains.DomainCourseGrade;
import com.kbtran.srframe.views.ViewCourseGrade;

public interface ICourseGradeConverter {

    DomainCourseGrade viewToDomain(ViewCourseGrade viewCourseGrade);

    ViewCourseGrade domainToView(DomainCourseGrade domainCourseGrade);

}
