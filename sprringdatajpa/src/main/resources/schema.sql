--This table used for "COMPONENT MAPPING IN JPA"
create table employee(id int,
	name varchar(30),
	address varchar(30),
	city varchar(20),
	state varchar(20),
	country varchar(20)
);

--The below two table used for ONE TO MANY AND MANY TO ONE
create table customer(
id int PRIMARY KEY,
name varchar(20)
);

create table phone_number(
id int PRIMARY KEY,
customer_id int,
number varchar(20),
type varchar(20),
FOREIGN KEY (customer_id)
REFERENCES customer(id)
);
-- ************************************************************
-- THESE 3 TABLE USED FOR MANY TO MANY  
create table programmer(
id int PRIMARY KEY,
name varchar(20),
salary int
);

create table project(
id int PRIMARY KEY,
name varchar(20)
);

create table programmers_projects(
programmer_id int,
project_id int,
FOREIGN KEY(programmer_id)
REFERENCES programmer(id),
FOREIGN KEY (project_id)
REFERENCES project(id)
);
-- ***********************************************************
-- THESE 2 TABLE USED FOR ONE TO ONE 
create table person(
id int PRIMARY KEY,
first_name varchar(20),
last_name varchar(20),
age int
);

create table license(
id int PRIMARY KEY,
type varchar(20),
valid_from date,
valid_tp date,
person_id int,
FOREIGN KEY(person_id)
REFERENCES person(id)
);
-- ***********************************************************

--THIS TABLE USE FOR TRANSACTION DEMO-------------------------
create table bankaccount(
	accno int,
	lastname varchar(20),
	firstname varchar(20),
	bal int
);

insert into bankaccount (accno,lastname,firstname,bal) values(113344,'kumar','red',5000);
insert into bankaccount (accno,lastname,firstname,bal) values(1234,'sing','blue',4000);
-- ************************************************************
--THIS TABLE USE FOR STORING FILES 
create table image(
id int PRIMARY KEY,
name varchar(100),
data BLOB
);
-- ************************************************************
--THIS TABLE USE FOR COMPOSITE KET
create table compositeexample(
	id int,
	email varchar(20),
	name varchar(20),
	PRIMARY KEY(id,email)	
);

--select c.email from compositeexample c
--     or
--select c.customerId.email from compositeexample c  
-- ************************************************************

--THIS TABLE USE FOR MULTIPLE DATABASE
--IT IS IN H2 DATABASE
create table coupon(
id int PRIMARY KEY,
code varchar(20)
);
-- IT IS IN MYSQL DATABASE OR VISE VERSA
create table product(
id int PRIMARY KEY,
name varchar(20)
);
