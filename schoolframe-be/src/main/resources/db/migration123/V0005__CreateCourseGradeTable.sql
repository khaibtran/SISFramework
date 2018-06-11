create table course_grade (
    course_grade_id         bigserial primary key,
    course_id               int(11) not null,
    student_id              int(11) not null,
    term_bin_id             int(11),
    ps_term_bin_id          int(11),
    score                   bigint,
    score_override          bigint,
    grading_scale_level_id  int(11),
    from_date               datetime,
    thru_date               datetime,
    active                  int,
    foreign key (student_id) references students(student_id)
)