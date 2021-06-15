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

insert into meeting
values(1, 'conference');
insert into meeting
values(2, 'consultation');
insert into meeting
values(3, 'briefing');

insert into users
values(1, 'Ivan');
insert into users
values(2, 'Den');
insert into users
values(3, 'Victor');
insert into users
values(4, 'Roman');



select * from potential_participants;

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

select  m.name, count(*) from 
potential_participants p
join meeting m
on (p.meeting_id = m.id)
group by m.name, meeting_id, status
having status = 'accept';

select m.name
from meeting m
join potential_participants p
on (p.meeting_id = m.id)
group by m.name, p.status
having count(status = 'deny') = 
(select count(*) from users);

