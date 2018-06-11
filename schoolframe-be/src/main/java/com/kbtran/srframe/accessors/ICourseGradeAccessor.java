package com.kbtran.srframe.accessors;

import com.kbtran.srframe.domains.DomainCourseGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseGradeAccessor extends JpaRepository<DomainCourseGrade, Long> {
}
