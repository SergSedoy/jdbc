create schema netology;

create table CUSTOMERS(
        id int primary key auto_increment,
        name varchar(255),
        surname varchar(255),
        age int check(age > 0),
        phone_number varchar(255)
);

insert into CUSTOMERS (name, surname, age, phone_number) values ('serg', 'sedoy', 33, '89998887755');
insert into CUSTOMERS (name, surname, age, phone_number) values ('oleg', 'petrov', 22, '89998887755');
insert into CUSTOMERS (name, surname, age, phone_number) values ('alexey', 'sergeev', 12, '81112223344');
insert into CUSTOMERS (name, surname, age, phone_number) values ('igor','igorev' , 42, '89211111111');
insert into CUSTOMERS (name, surname, age, phone_number) values ('vasya', 'boroda', 15, '89317899999');




create table ORDERS (
                        id int primary key auto_increment,
                        date varchar(255),
                        customer_id int NOT NULL,
                        product_name varchar(255),
                        amount int,
                        FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);

insert into ORDERS (date, customer_id, product_name, amount) values ('26.08.2021', 5, 'fanta', 789);
insert into ORDERS (date, customer_id, product_name, amount) values ('12.08.2021', 3, 'jcb', 508889);
insert into ORDERS (date, customer_id, product_name, amount) values ('09.05.2021', 1, 'asus', 321);
insert into ORDERS (date, customer_id, product_name, amount) values ('10.09.2021', 1, 'samsung', 80000);