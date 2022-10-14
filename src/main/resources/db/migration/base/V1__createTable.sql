drop table if exists student cascade;
drop sequence if exists student_sequence;

create table student (
     id int8 not null,
     dob date,
     email varchar(255),
     name varchar(255),
     primary key (id)
);

