import { Student } from './student';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class StudentService{

    private url:string = 'http://localhost:8080/api/v1/student';
    private http:HttpClient;

    constructor(http:HttpClient) {
        this.http = http;
    }

    getAllStudents(): Observable<Student[]> {
        return this.http.get<Student[]>(this.url);
    }

    getStudentById(studentId:number): Observable<Student> {
        return this.http.get<Student>(`${this.url}/${studentId}`);
    }

    createStudent(student:Student): Observable<Student> {
        return this.http.post<Student>(`${this.url}/`, student);
    }

    updateStudent(studentId:number, student:Student): Observable<Student> {
        return this.http.put<Student>(`${this.url}/${studentId}`, student);
    }

    deleteStudent(studentId:number): Observable<Student> {
        return this.http.delete<Student>(`${this.url}/${studentId}`);
    }
}