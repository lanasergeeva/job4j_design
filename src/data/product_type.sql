create table type(
    id serial primary key,
    name varchar(255)
);

create table products(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
	expired_date date,
	price float
);

select * from type;
select * from products;

insert into type
(name)
values('МОЛОКО');
insert into type
(name)
values('МОЛОЧНЫЕ ДЕСЕРТЫ');
insert into type
(name)
values('СЫР');
insert into type
(name)
values('МАСЛО');

insert into products 
(name, type_id, expired_date, price)
values('Гауда', 3, to_date('23-06-2021', 'DD-MM-YYYY'), 560.8);
/*10штук Моцарелла*/
insert into products 
(name, type_id, expired_date, price)
values('Моцарелла', 3, to_date('02-06-2021', 'DD-MM-YYYY'), 485.89);

insert into products 
(name, type_id, expired_date, price)
values('Простоквашино', 1, to_date('30-05-2021', 'DD-MM-YYYY'), 65.99);
insert into products 
(name, type_id, expired_date, price)
values('Кубанская буренка', 1, to_date('29-05-2021', 'DD-MM-YYYY'), 45);

insert into products 
(name, type_id, expired_date, price)
values('Magnat мороженное', 2, to_date('30-11-2021', 'DD-MM-YYYY'), 95);
insert into products 
(name, type_id, expired_date, price)
values('Кореновка мороженное', 2, to_date('30-04-2022', 'DD-MM-YYYY'), 75);

insert into products 
(name, type_id, expired_date, price)
values('Крестьянское', 4, to_date('30-06-2021', 'DD-MM-YYYY'), 84);

insert into products 
(name, type_id, expired_date, price)
values('Кореновка мороженное', 2, to_date('30-05-2022', 'DD-MM-YYYY'), 75);

select p.name, p.expired_date, p.price, t.name
from products p
join type t
on (p.type_id=t.id)
where t.name = 'СЫР';

select *
from products p
where name like '%мороженное%';

/*я специально год добавила. можно и без него*/
select * from products
where to_char(expired_date, 'MM') = to_char((current_date+interval '1' month), 'MM')
and to_char(expired_date, 'RR') = to_char((current_date + interval '1' month), 'RR');

select *
from products
where price =
(select max(price) from products);

select t.name name_of_type, COUNT(*)
from type t
join products p
on(p.type_id=t.id)
group by t.name;

select p.name products_name, p.expired_date, p.price, t.name type_of_products
from products p
join type t
on (p.type_id=t.id)
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name products_type, COUNT(*)
from type t
join products p
on(p.type_id=t.id)
group by t.name
having count(*) < 10;

select  *
from products p
join type t
on (p.type_id=t.id)
order by t.name;




