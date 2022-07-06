create table propertyName(
property_id int primary key not null ,
property_name varchar(100) not null
);

create table location(
location_id int primary key not null,
property_id int,
full_address varchar(200) not null,
state varchar(50) not null,
city varchar(50) not null,
neighborhood varchar(100) not null,
postal_code varchar(50) not null,
street_address varchar(100) not null,
FOREIGN KEY (property_id) REFERENCES propertyName(property_id)
);

create table coordinates(
coord_id int primary key not null,
property_id int,
FOREIGN KEY (property_id) REFERENCES propertyName(property_id),
latitude int,
longitude int 
);

create table units(
unit_id int primary key not null,
property_id int,
FOREIGN KEY (property_id) REFERENCES propertyName(property_id),
price int,
type varchar(50),
sqft int,
availability varchar(50),
model_name varchar(50),
lease_options varchar (50)
);

create table fees(
fee_id int primary key not null,
property_id int,
FOREIGN KEY (property_id) REFERENCES propertyName(property_id),
header varchar(50),
value varchar(50)
);

create table utilities(
fee_id int primary key not null,
property_id int,
FOREIGN KEY (property_id) REFERENCES propertyName(property_id),
name varchar(50),
value varchar(50)
);

create table propertyInformation(
info_id int primary key not null,
property_id int,
FOREIGN KEY (property_id) REFERENCES propertyName(property_id),
data varchar(50)
);









 