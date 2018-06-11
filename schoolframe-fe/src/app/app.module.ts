import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {
    SocialLoginModule,
    AuthServiceConfig,
    GoogleLoginProvider,
    FacebookLoginProvider,
} from "angular5-social-login";
import { ChartModule } from 'angular-highcharts';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HeaderLinksComponent } from './header-links/header-links.component';
import { StudentListComponent } from './student/student-list/student-list.component';
import { StudentService } from './student/student-service/student.service';
import { StudentCardComponent } from './student/student-card/student-card.component';
import { StudentDetailsComponent } from './student/student-details/student-details.component';
import { StudentFormComponent } from './student/student-form/student-form.component';
import { CourseGradeService } from './courseGrade/courseGrade-service/courseGrade.service';
import { CourseGradeListComponent } from './courseGrade/course-grade-list/course-grade-list.component';
import { CourseGradeDetailsComponent } from './courseGrade/course-grade-details/course-grade-details.component';
import { CourseGradeFormComponent } from './courseGrade/course-grade-form/course-grade-form.component';
import { CourseGradeCardComponent } from './courseGrade/course-grade-card/course-grade-card.component';
import { CourseCardComponent } from './course/course-card/course-card.component';
import { CourseDetailsComponent } from './course/course-details/course-details.component';
import { CourseFormComponent } from './course/course-form/course-form.component';
import { CourseListComponent } from './course/course-list/course-list.component';
import { CourseService } from './course/course-service/course.service';
import { SignInService } from './signin/signin.service';
import { SigninComponent } from './signin/signin.component';
import { AuthGuard } from './auth/auth.guard';

// Configs 
export function getAuthServiceConfigs() {
    let config = new AuthServiceConfig(
        [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider("658126784942-rfib7f0a4ihm15n2ngbhqev7av2o32dd.apps.googleusercontent.com")
          }
        ]
    );
    return config;
  }

@NgModule({
    declarations:[AppComponent, HeaderComponent, HeaderLinksComponent, StudentListComponent, StudentCardComponent, StudentDetailsComponent, StudentFormComponent, CourseGradeListComponent, CourseGradeDetailsComponent, CourseGradeFormComponent, CourseGradeCardComponent, CourseCardComponent, CourseDetailsComponent, CourseFormComponent, CourseListComponent, SigninComponent],

    imports:    [BrowserModule,
                 HttpClientModule,
                 SocialLoginModule,
                 ChartModule,
                 FormsModule,
                 RouterModule.forRoot([
                    {
                        path: 'students',
                        component: StudentListComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'students/create',
                        component: StudentFormComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'students/:studentId',
                        component: StudentDetailsComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'students/:studentId/update',
                        component: StudentFormComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'courseGrades',
                        component: CourseGradeListComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'courseGrades/create',
                        component: CourseGradeFormComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'courseGrades/:courseGradeId',
                        component: CourseGradeDetailsComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'courseGrades/:courseGradeId/update',
                        component: CourseGradeFormComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'courses',
                        component: CourseListComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'courses/create',
                        component: CourseFormComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'courses/:courseId',
                        component: CourseDetailsComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path: 'courses/:courseId/update',
                        component: CourseFormComponent,
                        canActivate: [AuthGuard]
                    },
                    {
                        path:'signin',
                        component: SigninComponent
                    }
                 ])
    ],

    providers:  [AuthGuard, SignInService, StudentService, CourseGradeService, CourseService, {provide: AuthServiceConfig,useFactory: getAuthServiceConfigs}],

    bootstrap:[AppComponent]
})
export class AppModule{ }