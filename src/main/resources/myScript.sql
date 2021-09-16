SELECT ORDERS.product_name FROM CUSTOMERS
       JOIN ORDERS ON CUSTOMERS.id = ORDERS.customer_id
       where name = :name