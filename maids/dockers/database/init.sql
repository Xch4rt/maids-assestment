create table Book (
id SERIAL primary key,
title varchar(128) not null,
author varchar (128),
publication_year integer,
ISBN varchar(20)
);

create table Patron (
id SERIAL primary key,
name varchar (100) not null
)

create table ContactInfo (
id SERIAL primary key,
patronId integer references Patron(id) ,
emailId integer references Email(id) NULL,
phoneId integer references NumberPhone(id) NULL
)

create table Email (
id SERIAL primary key,
email varchar (32) not null
)

create table NumberPhone (
id SERIAL primary key,
phone varchar (32)
)

create table BorrowingRecord (
	id SERIAL primary key,
	bookId integer references Book(id),
	patronId integer references Patron(id),
	borrowDate date,
	returnDate date
)
