create table orders (
	id int not null primary key identity(1,1),
	order_date date not null default getdate(),
	total int not null
)

create table orders_detail (
	id int not null primary key identity(1,1),
	order_id int not null foreign key references orders(id)
	book varchar(255) not null,
	quantity int not null
)
