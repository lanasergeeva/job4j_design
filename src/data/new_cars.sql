create table body(
id serial primary key,
name varchar(30)
);
create table engine(
id serial primary key,
type float
);
create table transmission(
id serial primary key,
name varchar(30)
);
create table car(
id serial primary key,
name varchar(30),
body_id int references body(id),
engine_id int references engine(id),
trans_id int references transmission(id)
);
insert into body
(name)
values('Sedan');
insert into body
(name)
values('Hatchback');
insert into body
(name)
values('Minivan');
insert into body
(name)
values('Coupe');

insert into engine
(type)
values(1.4);
insert into engine
(type)
values(1.6);
insert into engine
(type)
values(1.8);
insert into engine
(type)
values(2);

insert into transmission
(name)
values('AT');
insert into transmission
(name)
values('M');
insert into transmission
(name)
values('CVT');
insert into transmission
(name)
values('AM');


insert into car
(name, body_id, engine_id, trans_id)
values('Lada Vesta', 1, 3, 2);
insert into car
(name, body_id, engine_id, trans_id)
values('Peugeut Traveller', 3, 2, 1);
insert into car
(name, body_id, engine_id, trans_id)
values('Peugeut 308', 2, 1, 1);
insert into car
(name, body_id, engine_id, trans_id)
values('Renault Logan', 1, 2, 3);

select c.name car_name, b.name body, e.type engine, t.name type_trans
from car c
join body b
on (c.body_id = b.id)
join engine e
on (c.engine_id = e.id)
join transmission t
on (c.trans_id = t.id);

select b.name name_of_body
from car c
right join body b
on (c.body_id = b.id)
where c.name is null;

select e.type name_of_engine
from car c
right join engine e
on (c.engine_id = e.id)
where c.name is null;

select t.name type_of_trans
from transmission t
left join  car c
on (c.trans_id = t.id)
where c.name is null;



