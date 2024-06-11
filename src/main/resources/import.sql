-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into person (id, firstName, lastName) values(1, 'Jack', 'Sparrow');
insert into person (id, firstName, lastName) values(2, 'Captain', 'Barbosa');
alter sequence person_seq restart with 3;
