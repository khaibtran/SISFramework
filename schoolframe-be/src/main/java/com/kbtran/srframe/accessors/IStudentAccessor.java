package com.kbtran.srframe.accessors;

import com.kbtran.srframe.domains.DomainStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IStudentAccessor extends JpaRepository<DomainStudent, Long>{

    List<DomainStudent> findAllByactiveEquals(int active);

    //List<DomainStudent> findAllByFromDateAfterAndThruDateBefore(LocalDateTime startDate, LocalDateTime endDate);
}
