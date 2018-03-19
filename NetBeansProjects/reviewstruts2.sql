create database reviewstruts2

create table customer(
    custID varchar(10) not null primary key,
    password varchar(30) not null,
    fullname varchar(50),
    role int not null
)

create table orders(
    orderID int not null identity(1,1) primary key,
    orderDate datetime default (getdate()),
    custID varchar(10) not null foreign key references customer(custID),
    total float,
    isDeliver bit,
    reason varchar(25)
)

INSERT INTO customer (custID, password, fullname, "role") 
	VALUES ('hongphat', 'hongphat', 'Nguyen Hong Phat', 1);
INSERT INTO customer (custID, password, fullname, "role") 
	VALUES ('someone', 'someone', NULL, 2);
INSERT INTO customer (custID, password, fullname, "role") 
	VALUES ('user', 'user', 'User', 3);
