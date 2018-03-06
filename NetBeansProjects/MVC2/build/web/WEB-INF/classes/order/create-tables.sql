create table orders (
	id int not null primary key identity(1,1),
	order_date date not null default getdate(),
	total_quantity int not null
)

create table order_detail (
	id int not null primary key identity(1,1),
	order_id int not null foreign key references orders(id),
	product varchar(255) not null,
	quantity int not null
)
