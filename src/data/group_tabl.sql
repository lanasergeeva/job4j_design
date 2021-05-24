create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices
(name, price)
values('Смартфон', 11250.6);
insert into devices
(name, price)
values('Часы', 6500.50);
insert into devices
(name, price)
values('Наушники', 2500);
insert into devices
(name, price)
values('PowerBank',  3250.50);

insert into people
(name)
values('Григорий');
insert into people
(name)
values('Иван');
insert into people
(name)
values('Лев');
insert into people
(name)
values('Роман');

insert into devices_people
(people_id, device_id)
values(1, 2);
insert into devices_people
(people_id, device_id)
values(1, 3);
insert into devices_people
(people_id, device_id)
values(1, 4);

insert into devices_people
(people_id, device_id)
values(2, 2);
insert into devices_people
(people_id, device_id)
values(2, 1);

insert into devices_people
(people_id, device_id)
values(3, 3);
insert into devices_people
(people_id, device_id)
values(3, 1);
insert into devices_people
(people_id, device_id)
values(3, 4);

insert into devices_people
(people_id, device_id)
values(4, 1);
insert into devices_people
(people_id, device_id)
values(4, 4);

select avg(price)
from devices;

select p.name, avg(price) allprice
from devices_people dp
join devices d
on(d.id = dp.device_id)
join people p
on(p.id = dp.device_id)
group by p.name
order by allprice desc;

select p.name, avg(price) allprice
from devices_people dp
join devices d
on(d.id = dp.device_id)
join people p
on(p.id = dp.device_id)
group by p.name
having avg(price) > 5000
order by allprice desc;
