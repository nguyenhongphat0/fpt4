CREATE DATABASE workshop2

CREATE TABLE tbl_Mobile (
    mobileId varchar(10) not null primary key,
    description varchar(250) not null,
    price float,
    mobileName varchar(20) not null,
    yearOfProduction int,
    quantity int,
    notSale bit default 0
)

CREATE TABLE tbl_User (
    userId varchar(20) not null primary key,
    password int not null,
    fullName varchar(50) not null,
    role int
)

INSERT INTO tbl_user (userId, password, fullName, "role") 
	VALUES ('manager', 1234, 'A Manager', 1);
INSERT INTO tbl_user (userId, password, fullName, "role") 
	VALUES ('nguyenhongphat0', 1234, 'Nguyen Hong Phat', 1);
INSERT INTO tbl_user (userId, password, fullName, "role") 
	VALUES ('phungquocviet', 1234, 'Quoc Viet', 0);
INSERT INTO tbl_user (userId, password, fullName, "role") 
	VALUES ('staff', 1234, 'A Staff', 2);
INSERT INTO tbl_user (userId, password, fullName, "role") 
	VALUES ('user', 1234, 'A User', 0);

CREATE TABLE tbl_Order (
	orderId int NOT NULL IDENTITY(1,1),
	orderDate datetime DEFAULT (getdate()),
	userId varchar(20) NOT NULL,
	CONSTRAINT tbl_Order_PK PRIMARY KEY (orderId),
	CONSTRAINT tbl_Order_tbl_User_FK FOREIGN KEY (userId) REFERENCES tbl_User(userId) ON DELETE CASCADE
) 

CREATE TABLE tbl_OrderDetail (
	id int NOT NULL IDENTITY(1,1),
	orderId int NOT NULL,
	mobileId varchar(10) NOT NULL,
	quantity int NOT NULL,
	CONSTRAINT tbl_OrderDetail_PK PRIMARY KEY (id),
	CONSTRAINT tbl_OrderDetail_tbl_Mobile_FK FOREIGN KEY (mobileId) REFERENCES tbl_Mobile(mobileId) ON DELETE CASCADE,
	CONSTRAINT tbl_OrderDetail_tbl_Order_FK FOREIGN KEY (orderId) REFERENCES tbl_Order(orderId) ON DELETE CASCADE
) 
