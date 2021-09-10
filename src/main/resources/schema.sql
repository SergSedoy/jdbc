create table CUSTOMERS
(
    id           int primary key auto_increment,
    name         varchar(255),
    surname      varchar(255),
    age          int check (age > 0),
    phone_number varchar(255)
)

