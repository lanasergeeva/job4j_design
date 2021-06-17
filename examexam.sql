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

select  m.name, count(*) from 
potential_participants p
join meeting m
on (p.meeting_id = m.id)
group by m.name, meeting_id, status
having status = 'accept';

select m.name, count(*) from meeting m 
join potential_participants p
on(m.id=p.meeting_id)
group by  m.name, p.users_id
having count(*) = 0 or
 p.users_id is null;


