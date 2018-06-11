package com.kbtran.srframe.accessors;

import com.kbtran.srframe.domains.DomainCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseAccessor extends JpaRepository<DomainCourse, Long> {

}
