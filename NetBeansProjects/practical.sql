create database PracticalTest

create table tbl_Customer (
    id varchar(20) not null primary key,
    fullName nvarchar(50) not null,
    phoneNumber varchar(30) not null,
    address nvarchar(250) not null,
    customerLevel int,
    password varchar(30) not null
)

create table tbl_Order (
    id varchar(10) not null primary key,
    orderDate datetime not null default (getdate()),
    total float,
    isDeliver bit,
    customerId varchar(20) not null foreign key references tbl_Customer(id)
)

create table tbl_Book (
    bookId varchar(10) not null primary key,
    bookTitle varchar(50) not null,
    description varchar(250) not null,
    author varchar(50) not null,
    publisher varchar(50) not null,
    price float
)