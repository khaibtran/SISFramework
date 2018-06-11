import { Course } from './course';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CourseService {

    private url:string = 'http://localhost:8080/api/v1/course/';
    private http:HttpClient;

    constructor(http:HttpClient) {
        this.http = http;
    }

    getAllCourses():Observable<Course[]> {
        return this.http.get<Course[]>(`${this.url}`);
    }

    getCourseById(courseId:number):Observable<Course> {
        return this.http.get<Course>(`${this.url}/${courseId}`);
    }

    createCourse(course:Course):Observable<Course> {
        return this.http.post<Course>(`${this.url}`, course);
    }

    updateCourse(courseId:number, course:Course):Observable<Course> {
        return this.http.put<Course>(`${this.url}/${courseId}`, course);
    }

    deleteCourse(courseId:number):Observable<Course> {
        return this.http.delete<Course>(`${this.url}/${courseId}`);
    }

}