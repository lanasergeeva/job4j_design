create table students1(
id serial primary key,
name varchar(20),
surname varchar(20),
age  integer,
course integer
);
create table contacts1(
id serial primary key,
email varchar(30),
phone_number varchar(20),
student_id int references students1(id)
);
select * from students1;
select * from contacts1;

insert into students1
(name, surname, age, course)
values ('Ivan', 'Ivanov', 21, 2);
insert into students1
(name, surname, age, course)
values ('Oleg', 'Malinov', 25, 4);
insert into students1
(name, surname, age, course)
values ('Nika', 'Nikitina', 18, 1);

insert into contacts1
(email, phone_number, student_id)
values('ivani@gmail.com', '79787767676', 1);
insert into contacts1
(email, phone_number, student_id)
values('olegi@gmail.com', '79787789632', 2);
insert into contacts1
(email, phone_number, student_id)
values('nuka@gmail.com', '79781548976', 3);

select * from students1 st
join contacts1 c
on (st.id=c.student_id);

select st.id col_stid, st.name col_name, st.surname col_surname, 
c.phone_number col_number
from students1 st
join contacts1 c
on (st.id=c.student_id)
where surname like '%i%';

select st.id col_id, st.name col_name, 
st.age col_age, c.email col_email, c.student_id st_id
from students1 st
join contacts1 c
on (st.id=c.student_id)
where age > 20;

select st.id col_id, st.name col_name, 
c.phone_number col_number, c.email col_email
from students1 st
join contacts1 c
on (st.id=c.student_id)
where st.course > 1 and  SUBSTR(c.email, 1, 1) != 'i' ;

