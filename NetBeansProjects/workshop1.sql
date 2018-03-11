CREATE DATABASE workshop1

CREATE TABLE workshop1.dbo.tbl_User (
	userId varchar(20) NOT NULL,
	password int NOT NULL,
	fullName varchar(50) NOT NULL,
	[role] int,
	CONSTRAINT tbl_User_PK PRIMARY KEY (userId)
) 

INSERT INTO workshop1.dbo.tbl_User (userId,password,fullName,[role]) VALUES 
('nguyenhongphat0',28121998,'Nguyen Hong Phat',1)
,('phungquocviet',1234,'Phung Quoc Viet',0)
,('trinhxuannhan',1234,'Trinh Xuan Nhan',0)
,('truongnamthanh',1234,'Truong Nam Thanh',2)

CREATE TABLE workshop1.dbo.tbl_Mobile (
	mobileId varchar(10) NOT NULL,
	description varchar(250) NOT NULL,
	price float,
	mobileName varchar(20) NOT NULL,
	yearOfProduction int,
	quantity int,
	notSale bit,
	CONSTRAINT tbl_Mobile_PK PRIMARY KEY (mobileId)
) 

CREATE TABLE workshop1.dbo.tbl_Order (
	orderId int NOT NULL IDENTITY(1,1),
	orderDate datetime DEFAULT (getdate()),
	userId varchar(20) NOT NULL,
	CONSTRAINT tbl_Order_PK PRIMARY KEY (orderId),
	CONSTRAINT tbl_Order_tbl_User_FK FOREIGN KEY (userId) REFERENCES workshop1.dbo.tbl_User(userId) ON DELETE CASCADE
) 

CREATE TABLE workshop1.dbo.tbl_OrderDetail (
	id int NOT NULL IDENTITY(1,1),
	orderId int NOT NULL,
	mobileId varchar(10) NOT NULL,
	quantity int NOT NULL,
	CONSTRAINT tbl_OrderDetail_PK PRIMARY KEY (id),
	CONSTRAINT tbl_OrderDetail_tbl_Mobile_FK FOREIGN KEY (mobileId) REFERENCES workshop1.dbo.tbl_Mobile(mobileId) ON DELETE CASCADE,
	CONSTRAINT tbl_OrderDetail_tbl_Order_FK FOREIGN KEY (orderId) REFERENCES workshop1.dbo.tbl_Order(orderId) ON DELETE CASCADE
) 


