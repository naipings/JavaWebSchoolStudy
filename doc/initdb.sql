create database bookstore;

create table book (
    id int auto_increment primary key,
    name varchar(50) not null,
    author varchar(50) not null,
    price decimal(10,2) not null,
    content varchar(500) not null,
    );

insert into bookstore.users VALUES('Tom', '123456')
insert into bookstore.users VALUES('Jerry', '123456')
delete from bookstore.users where user='Tom'

select * from users
select id, name, author, price, content from book

insert into book VALUES('1', 'Java Programming', 'Tom', 34.8, 'Java Tutorial for web development')
insert into book VALUES('2', 'Linux Server Management', 'Jerry', 50.0, 'How to provide service by Linux')

insert into users values()
delete from book where id = 3


