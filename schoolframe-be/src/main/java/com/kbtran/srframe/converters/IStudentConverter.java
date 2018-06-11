package com.kbtran.srframe.converters;

import com.kbtran.srframe.domains.DomainStudent;
import com.kbtran.srframe.views.ViewStudent;

public interface IStudentConverter {

    DomainStudent viewToDomain(ViewStudent viewStudent);

    ViewStudent domainToView(DomainStudent domainStudent);
}
