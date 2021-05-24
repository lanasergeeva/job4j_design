create table students(
student_id integer,
name varchar(20),
surname varchar(20),
age  integer,
course integer
);

create table contacts(
student_id integer,
email varchar(30),
phone_number varchar(20)
);

insert into students
values (20, 'Ivan', 'Ivanov', 21, 2);
insert into students
values (21, 'Oleg', 'Malinov', 25, 4);
insert into students
values (22, 'Nika', 'Nikitina', 18, 1);

insert into contacts(student_id) 
select student_id from students;

update contacts 
set email = 'ivani@gmail.com',
phone_number = '79787767676'
where student_id = 20;

update contacts 
set email = 'olegi@gmail.com',
phone_number = '79787789632'
where student_id = 21;

update contacts 
set email = 'nuka@gmail.com',
phone_number = '79781548976'
where student_id = 22;

select * from students st
join contacts c
on (st.student_id=c.student_id);

select st.student_id col_id, st.name col_name, st.surname col_surname, 
c.phone_number col_number
from students st
join contacts c
on (st.student_id=c.student_id)
where surname like '%i%';

select st.student_id col_id, st.name col_name, st.age col_age, c.email
from students st
join contacts c
on (st.student_id=c.student_id)
where age > 20;

select st.student_id col_id, st.name col_name, 
c.phone_number col_number, c.email col_email
from students st
join contacts c
on (st.student_id=c.student_id)
where st.course > 1 and  SUBSTR(c.email, 1, 1) != 'i' ;
