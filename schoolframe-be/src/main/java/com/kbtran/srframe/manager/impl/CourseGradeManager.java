package com.kbtran.srframe.manager.impl;

import com.kbtran.srframe.accessors.ICourseGradeAccessor;
import com.kbtran.srframe.converters.ICourseGradeConverter;
import com.kbtran.srframe.domains.DomainCourse;
import com.kbtran.srframe.domains.DomainCourseGrade;
import com.kbtran.srframe.manager.ICourseGradeManager;
import com.kbtran.srframe.views.ViewCourseGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseGradeManager implements ICourseGradeManager {

    @Autowired
    private ICourseGradeAccessor courseGradeAccessor;

    @Autowired
    private ICourseGradeConverter courseGradeConverter;

    @Override
    public List<ViewCourseGrade> getAllCourseGrades() {
        return courseGradeAccessor.findAll().stream()
                .map(courseGradeConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewCourseGrade getCourseGradeById(Long courseGradeId) {
        DomainCourseGrade domainCourseGrade = courseGradeAccessor.findOne(courseGradeId);
        if (domainCourseGrade == null) {
            return null;
        }

        return courseGradeConverter.domainToView(domainCourseGrade);
    }

    @Override
    public ViewCourseGrade createCourseGrade(ViewCourseGrade viewCourseGrade) {
        return courseGradeConverter.domainToView(courseGradeAccessor.save(courseGradeConverter.viewToDomain(viewCourseGrade)));
    }

    @Override
    public ViewCourseGrade updateCourseGrade(Long courseGradeId, ViewCourseGrade viewCourseGrade) {
        DomainCourseGrade currentCourseGrade = courseGradeAccessor.findOne(courseGradeId);
        if (currentCourseGrade == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + courseGradeId.toString());
        } else if (!(viewCourseGrade.getCourseGradeId() == courseGradeId)) {
            throw new InvalidParameterException("Provided post id: " + courseGradeId + " does not match provided post: " + viewCourseGrade);
        }

        return courseGradeConverter.domainToView(courseGradeAccessor.save(courseGradeConverter.viewToDomain(viewCourseGrade)));
    }

    @Override
    public ViewCourseGrade deleteCourseGrade(Long courseGradeId) {
        DomainCourseGrade currentCourseGrade = courseGradeAccessor.getOne(courseGradeId);
        if(currentCourseGrade == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + courseGradeId.toString());
        }

        courseGradeAccessor.delete(courseGradeId);
        return courseGradeConverter.domainToView(currentCourseGrade);
    }
}
