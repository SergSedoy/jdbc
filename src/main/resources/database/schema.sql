CREATE TABLE IF NOT EXISTS CUSTOMERS
(
    id           int primary key auto_increment,
    name         varchar(255),
    surname      varchar(255),
    age          int check (age > 0),
    phone_number varchar(255)
);

CREATE TABLE IF NOT EXISTS ORDERS (
                        id int primary key auto_increment,
                        date varchar(255),
                        customer_id int NOT NULL,
                        product_name varchar(255),
                        amount int,
                        FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);

