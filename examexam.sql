create table meeting(
id integer primary key,
name varchar(50)
);

create table users(
id integer primary key,
name varchar(50)
);

create table potential_participants(
id integer primary key,
users_id integer references users (id),
meeting_id integer references meeting(id),
status varchar check (status = 'accept' or status = 'deny')
);

delete from potential_participants;

insert into potential_participants
values(1, 1, 1, 'accept');
insert into potential_participants
values(2, 2, 1, 'deny');
insert into potential_participants
values(3, 3, 1, 'deny');
insert into potential_participants
values(4, 4, 1, 'accept');
insert into potential_participants
values(5, 1, 2, 'deny');
insert into potential_participants
values(6, 2, 2, 'deny');
insert into potential_participants
values(7, 3, 2, 'deny');
insert into potential_participants
values(8, 4, 2, 'deny');
insert into potential_participants
values(9, 1, 3, 'accept');
insert into potential_participants
values(10, 2, 3, 'deny');
insert into potential_participants
values(11, 3, 3, 'accept');
insert into potential_participants
values(12, 4, 3, 'accept');

select * from potential_participants;

select  m.name, count(*) from 
potential_participants p
join meeting m
on (p.meeting_id = m.id)
group by m.name, meeting_id, status
having status = 'accept';

select m.name, count(*) 
from meeting m 
join potential_participants p
on(m.id=p.meeting_id)
where m.name = (
select name from meeting where id=2 ) 
and 
p.status = 'deny'
group by  m.name;

