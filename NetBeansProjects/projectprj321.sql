CREATE DATABASE projectprj321
CREATE TABLE projectprj321.dbo.customer (
	custID varchar(10) NOT NULL,
	password varchar(30) NOT NULL,
	custName varchar(15),
	lastName varchar(15),
	middleName varchar(15),
	address varchar(250),
	phone varchar(11),
	custLevel int,
	CONSTRAINT customer_PK PRIMARY KEY (custID)
)
CREATE TABLE projectprj321.dbo.tbl_book (
	bookID varchar(10) NOT NULL,
	title varchar(50),
	price float NOT NULL,
	quantity int NOT NULL,
	CONSTRAINT tbl_book_PK PRIMARY KEY (bookID)
)
CREATE TABLE projectprj321.dbo.tbl_order (
	orderID varchar(10) NOT NULL,
	orderDate datetime DEFAULT (getdate()) NOT NULL,
	custID varchar(10) NOT NULL,
	total float,
	isDeliver bit,
	Reason varchar(250),
	CONSTRAINT tbl_order_PK PRIMARY KEY (orderID),
	CONSTRAINT tbl_order_customer_FK FOREIGN KEY (custID) REFERENCES projectprj321.dbo.customer(custID) ON DELETE CASCADE
)
CREATE TABLE projectprj321.dbo.tbl_orderDetail (
	id int NOT NULL IDENTITY(1,1),
	productID varchar(10) NOT NULL,
	quantity int NOT NULL,
	unitPrice float,
	total float,
	orderID varchar(10) NOT NULL,
	CONSTRAINT tbl_orderDetail_PK PRIMARY KEY (id),
	CONSTRAINT tbl_orderDetail_tbl_book_FK FOREIGN KEY (productID) REFERENCES projectprj321.dbo.tbl_book(bookID) ON DELETE CASCADE,
	CONSTRAINT tbl_orderDetail_tbl_order_FK FOREIGN KEY (orderID) REFERENCES projectprj321.dbo.tbl_order(orderID) ON DELETE CASCADE
)
INSERT INTO projectprj321.dbo.customer (custID,password,custName,lastName,middleName,address,phone,custLevel) VALUES 
('another','1234','Just','Another','Person','Hello','+123133',0)
,('hongphat','hongphat','Phat','Nguyen','Hong','Long An','0903670437',1)
,('lykiet','1234','Kiet','Ly','','123','1231231',0)
,('quocviet','quocviet','Viet','Quoc',NULL,NULL,NULL,NULL)
INSERT INTO projectprj321.dbo.tbl_book (bookID,title,price,quantity) VALUES 
('jsp','JSP',20000,12)
,('servlet','Servlet',3000000,14)
,('spring','Spring Frameworks',1230000,75)
,('struts','STRUTS 2',250000,0)