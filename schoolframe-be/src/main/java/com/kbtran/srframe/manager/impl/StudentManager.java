package com.kbtran.srframe.manager.impl;

import com.kbtran.srframe.accessors.IStudentAccessor;
import com.kbtran.srframe.converters.ILocalDateTimeConverter;
import com.kbtran.srframe.converters.IStudentConverter;
import com.kbtran.srframe.domains.DomainStudent;
import com.kbtran.srframe.manager.IStudentManager;
import com.kbtran.srframe.views.ViewStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentManager implements IStudentManager {

    @Autowired
    private IStudentAccessor studentAccessor;

    @Autowired
    private IStudentConverter studentConverter;

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;



    @Override
    public List<ViewStudent> getAllStudents() {
        return studentAccessor.findAll().stream()
                .map(studentConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewStudent getStudentById(Long studentId) {
        DomainStudent domainStudent = studentAccessor.findOne(studentId);
        if (domainStudent == null) {
            return null;
        }

        return studentConverter.domainToView(domainStudent);
    }

    @Override
    public ViewStudent createStudent(ViewStudent viewStudent) {
        return studentConverter.domainToView(studentAccessor.save(studentConverter.viewToDomain(viewStudent)));
    }

    @Override
    public ViewStudent updateStudent(Long studentId, ViewStudent viewStudent) {
        DomainStudent currentStudent = studentAccessor.findOne(studentId);
        if (currentStudent == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + studentId.toString());
        } else if (!(viewStudent.getStudentId() == studentId)) {
            throw new InvalidParameterException("Provided post id: " + studentId + " does not match provided post: " + viewStudent);
        }

        return studentConverter.domainToView(studentAccessor.save(studentConverter.viewToDomain(viewStudent)));
    }

    @Override
    public ViewStudent deleteStudent(Long studentId) {
        DomainStudent domainStudent = studentAccessor.getOne(studentId);
        if(domainStudent == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + studentId.toString());
        }

        studentAccessor.delete(studentId);
        return studentConverter.domainToView(domainStudent);
    }

//    @Override
//    public List<ViewStudent> getStudentByDate(Long startDate, Long endDate) {
//        LocalDateTime ldtStartDate = localDateTimeConverter.convertLongToLocalDateTime(startDate);
//        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
//        return studentAccessor.findAllByFromDateAfterAndThruDateBefore(ldtStartDate, ldtEndDate).stream()
//                .map(studentConverter::domainToView)
//                .collect(Collectors.toList());
//    }

}

