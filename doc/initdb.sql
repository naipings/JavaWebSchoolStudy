create database bookstore;

create table book (
    id int auto_increment primary key,
    name varchar(50) not null,
    author varchar(50) not null,
    price decimal(10,2) not null,
    content varchar(500) not null,
    );
