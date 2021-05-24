
create table "role" (
 id serial primary key,
 name varchar(20)
);

create table "user" (
 id serial primary key,
 name varchar(20),
 role_id int references "role"(id)
);

create table rules (
 id serial primary key,
 name varchar(20)
);

create table role_and_rules (
 id serial primary key,
 role_id int references "role"(id),
 rules_id int references rules(id)
);

create table category (
id serial primary key,
 name varchar(20)
);

create table "state" (
id serial primary key,
 name varchar(20)
);

create table item (
 id serial primary key,
 name varchar(20),
 user_id int references "user"(id),
 category_id int references category(id),
 state_id int references "state"(id)
);

create table "comments" (
 id serial primary key,
 comment text,
 item_id int references item(id)
);

create table attachs (
 id serial primary key,
 name varchar(20),
 item_id int references item(id)
);





