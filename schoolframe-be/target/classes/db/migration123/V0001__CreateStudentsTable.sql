create table students (
    student_id      int(11) primary key,
    user_id         int(11),
    first_name      varchar(255) not null,
    last_name       varchar(225) not null,
    school_id       int(11),
    grade_level_id  int(11),
    external_id     int(11),
    sis_id          int(11),
    state_id        int(11),
    from_date       datetime,
    thru_date       datetime,
    active          int(1)
)