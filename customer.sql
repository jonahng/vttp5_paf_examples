drop database if exists acme;


create database acme;

use acme;

create table employees (
    emp_id char(8) not null,
    name varchar(128) not null,
    salary decimal(10, 2) default 4500,
    dob date not null,
    dept int,

    constraint pk_emp_id primary key(emp_id),
);




create table dept (
    dept_id int auto_increment,
    name varchar(64) not null,
    constraint pk_dept_id primary key(dept_id));

GRANT all privileges on acme.* to 'test3'@'%';
flush privileges;
