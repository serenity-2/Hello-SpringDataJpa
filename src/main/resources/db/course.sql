-- auto-generated definition
create table Course
(
    id          int auto_increment
        primary key,
    course_no   varchar(32)                        not null comment '课程编号',
    course_name varchar(32)                        not null comment '课程名称',
    create_by   varchar(32)                        null,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_by   varchar(32)                        null,
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint idx_unique_courseNo
        unique (course_no)
);
