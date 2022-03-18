create table person
(
    id          serial primary key not null,
    login       varchar(2000),
    password    varchar(2000),
    employee_id int references employee (id)
);

create table employee
(
    id       serial primary key not null,
    name     varchar(128),
    age      int,
    inn      bigint,
    hireDate timestamptz
);


insert into employee (name, age, inn, hireDate)
VALUES ('Andrey', 30, 123123, '18-03-2022'),
       ('Petr', 31, 746565, '17-03-2022'),
       ('Dmitriy', 32, 444443, '15-03-2022');

insert into person (login, password, employee_id)
values ('login111', '123', 1),

       ('login222', '123', 2),

       ('login3333', '123', 3);