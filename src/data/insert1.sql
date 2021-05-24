insert into "role"
(name)
values('admin');
insert into "role"
(name)
values('manager');

insert into "user"
(name, role_id)
values('Ivan', 1);
insert into "user"
(name, role_id)
values('Nikita', 2);
 
insert into rules
(name)
values('add');

insert into rules
(name)
values('delete');

insert into rules
(name)
values('read');

insert into role_and_rules
(role_id, rules_id)
values(1, 1);
insert into role_and_rules
(role_id, rules_id)
values(1, 2);
insert into role_and_rules
(role_id, rules_id)
values(2, 3);

insert into category
(name)
values('active');

insert into category
(name)
values('takedown');

insert into "state"
(name)
values('Waiting for support');

insert into item
(name, user_id, category_id, state_id)
values('add table', 2, 1, 1);

insert into "comments" 
(comment, item_id)
values('table name is Drinks', 1);

insert into attachs 
(name, item_id)
values('price of drinks', 1);




