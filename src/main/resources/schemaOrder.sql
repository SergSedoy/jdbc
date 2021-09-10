create table ORDERS (
                        id int primary key auto_increment,
                        date varchar(255),
                        customer_id int NOT NULL,
                        product_name varchar(255),
                        amount int,
                        FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
)
