insert into customer(id, name) values (1000, 'Matt');
insert into customer(id, name) values (1001, 'Luis');
insert into customer(id, name) values (1002, 'Selene');

insert into transaction(id, description, total, save_date, customer_id) values (1001, 'Purchase 1', 100, '2019-10-17 10:20:10', 1000);
insert into transaction(id, description, total, save_date, customer_id) values (1002, 'Purchase 2', 50, '2019-10-01 10:20:10', 1000);
insert into transaction(id, description, total, save_date, customer_id) values (1003, 'Purchase 3', 120, '2019-10-10 10:20:10', 1000);