create database workshop2

create table tbl_Mobile (
    mobileId varchar(10) not null primary key,
    description varchar(250) not null,
    price float,
    mobileName varchar(20) not null,
    yearOfProduction int,
    quantity int,
    notSale bit default 0
)

create table tbl_User (
    userId varchar(20) not null primary key,
    password int not null,
    fullName varchar(50) not null,
    role int
)