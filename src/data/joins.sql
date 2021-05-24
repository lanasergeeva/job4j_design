create table employees_table(
id serial primary key,
name varchar(255),
department_id int references departments(id)
);

create table departments (
id serial primary key,
name varchar(255)
);

insert into departments
(name)
values('IT');

insert into departments
(name)
values('Clerks');

insert into departments
(name)
values('Bookkeeping');

insert into departments
(name)
values('Sales');

insert into employees_table
(name, department_id)
values('Ivan', 1);

insert into employees_table
(name, department_id)
values('Nikita', 2);

insert into employees_table
(name, department_id)
values('Oleg',3);

insert into employees_table
(name, department_id)
values('Anton', 3);

insert into employees_table
(name)
values('Sergey');

insert into employees_table
(name)
values('Lev');

select * from departments d 
left join employees_table e
on(e.department_id=d.id);

select * from employees_table e
left join departments d 
on(e.department_id=d.id);

select * from employees_table e
right join departments d 
on(e.department_id=d.id);

select * from employees_table e
full join departments d 
on(e.department_id=d.id);

select * from employees_table e
cross join departments d;

/*department without employees*/
select * from departments d 
left join employees_table e
on(e.department_id=d.id)
where e.name is  null;

/*same output*/
select d.id dep_id, d.name dep_name, e.id emp_id, e.name emp_name, e.department_id dep_id
from employees_table e
right join departments d 
on(e.department_id=d.id);

select d.id dep_id, d.name dep_name, e.id emp_id, e.name emp_name, e.department_id dep_id
from departments d 
left join employees_table e
on(e.department_id=d.id);

create table teens(
id serial primary key,
name varchar(20),
gender varchar(20)
);

insert into teens
(name, gender)
values('Ivan', 'M');

insert into teens
(name, gender)
values('Sergey', 'M');

insert into teens
(name, gender)
values('Maria', 'f');

insert into teens
(name, gender)
values('Kate', 'f');

insert into teens
(name, gender)
values('Polina', 'f');

insert into teens
(name, gender)
values('Oleg', 'M');

insert into teens
(name, gender)
values('Irina', 'F');

insert into teens
(name, gender)
values('Lev', 'M');

insert into teens
(name, gender)
values('Nazar', 'm');


select * from teens t1
cross join teens t2
where upper(t1.gender) != upper(t2.gender);





