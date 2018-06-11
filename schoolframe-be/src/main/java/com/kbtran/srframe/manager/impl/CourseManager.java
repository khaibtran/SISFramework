package com.kbtran.srframe.manager.impl;

import com.kbtran.srframe.accessors.ICourseAccessor;
import com.kbtran.srframe.converters.ICourseConverter;
import com.kbtran.srframe.domains.DomainCourse;
import com.kbtran.srframe.manager.ICoursesManager;
import com.kbtran.srframe.views.ViewCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseManager implements ICoursesManager {

    @Autowired
    private ICourseAccessor courseAccessor;

    @Autowired
    private ICourseConverter courseConverter;

    @Override
    public List<ViewCourse> getAllCourses() {
        return courseAccessor.findAll().stream()
                .map(courseConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewCourse getCourseById(Long courseId) {
        DomainCourse domainCourse = courseAccessor.findOne(courseId);
        if (domainCourse == null) {
            return null;
        }

        return courseConverter.domainToView(domainCourse);
    }

    @Override
    public ViewCourse createCourse(ViewCourse viewCourse) {
        return courseConverter.domainToView(courseAccessor.save(courseConverter.viewToDomain(viewCourse)));
    }

    @Override
    public ViewCourse updateCourse(Long courseId, ViewCourse viewCourse) {
        DomainCourse currentStudent = courseAccessor.findOne(courseId);
        if (currentStudent == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + courseId.toString());
        } else if (!(viewCourse.getCourseId() == courseId)) {
            throw new InvalidParameterException("Provided post id: " + courseId + " does not match provided post: " + viewCourse);
        }

        return courseConverter.domainToView(courseAccessor.save(courseConverter.viewToDomain(viewCourse)));
    }

    @Override
    public ViewCourse deleteCourse(Long courseId) {
        DomainCourse domainCourse = courseAccessor.getOne(courseId);
        if(domainCourse == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + courseId.toString());
        }

        courseAccessor.delete(courseId);
        return courseConverter.domainToView(domainCourse);
    }
}
