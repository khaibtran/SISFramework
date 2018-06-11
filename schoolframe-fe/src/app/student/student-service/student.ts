import { CourseGrade } from '../../courseGrade/courseGrade-service/courseGrade';

export class Student {
    studentId: number;
    userId: number;
    firstName: string;
    lastName: string;
    schoolId: number;
    gradeLevelId: number;
    active: number;
    courseGrades: CourseGrade[];
}