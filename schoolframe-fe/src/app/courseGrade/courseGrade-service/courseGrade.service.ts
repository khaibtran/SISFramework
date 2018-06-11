import { CourseGrade } from './courseGrade';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { IfObservable } from 'rxjs/observable/IfObservable';

@Injectable()
export class CourseGradeService {

    private url:string = 'http://localhost:8080/api/v1/coursegrade';
    private courseGrades:CourseGrade[];
    private http:HttpClient;

    constructor(http:HttpClient) {
        this.http = http;
    }

    getAllCourseGrades():Observable<CourseGrade[]> {
        return this.http.get<CourseGrade[]>(this.url);
    }

    getCourseGradeById(courseGradeId:number):Observable<CourseGrade> {
        return this.http.get<CourseGrade>(`${this.url}/${courseGradeId}`);
    }

    createCourseGrade(courseGrade:CourseGrade):Observable<CourseGrade> {
        return this.http.post<CourseGrade>(`${this.url}/`, courseGrade);
    }

    updateCourseGrade(courseGradeId:number, courseGrade:CourseGrade):Observable<CourseGrade> {
        return this.http.put<CourseGrade>(`${this.url}/${courseGradeId}`, courseGrade);
    }

    deleteCourseGrade(courseGradeId:number):Observable<CourseGrade> {
        return this.http.delete<CourseGrade>(`${this.url}/${courseGradeId}`);
    }

}