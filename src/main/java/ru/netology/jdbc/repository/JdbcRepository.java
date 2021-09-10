package ru.netology.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class JdbcRepository {
    private final String scriptCreateCustomers = read("schema.sql");
    private final String scriptCreateOrders = read("schemaOrder.sql");
    private final String scriptQuery = read("myScript.sql");
    private static int count = 0;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        if(count < 1) {
            jdbcTemplate.execute("drop table ORDERS");
            jdbcTemplate.execute("drop table CUSTOMERS");
            jdbcTemplate.execute(scriptCreateCustomers);
            jdbcTemplate.execute("insert into CUSTOMERS (name, surname, age, phone_number) values ('serg', 'sedoy', 33, '89998887755')");
            jdbcTemplate.execute("insert into CUSTOMERS (name, surname, age, phone_number) values ('oleg', 'petrov', 22, '89998887755')");
            jdbcTemplate.execute("insert into CUSTOMERS (name, surname, age, phone_number) values ('alexey', 'sergeev', 12, '81112223344')");
            jdbcTemplate.execute("insert into CUSTOMERS (name, surname, age, phone_number) values ('igor','igorev' , 42, '89211111111')");
            jdbcTemplate.execute("insert into CUSTOMERS (name, surname, age, phone_number) values ('vasya', 'boroda', 15, '89317899999')");

            jdbcTemplate.execute(scriptCreateOrders);
            jdbcTemplate.execute("insert into ORDERS (date, customer_id, product_name, amount) values ('26.08.2021', 5, 'fanta', 789)");
            jdbcTemplate.execute("insert into ORDERS (date, customer_id, product_name, amount) values ('12.05.2021', 3, 'jcb', 508889)");
            jdbcTemplate.execute("insert into ORDERS (date, customer_id, product_name, amount) values ('09.11.2021', 1, 'asus', 321)");
            jdbcTemplate.execute("insert into ORDERS (date, customer_id, product_name, amount) values ('10.09.2021', 1, 'samsung', 80000)");
        count++;
        }
        return namedParameterJdbcTemplate.queryForList(scriptQuery, Map.of("name", name), String.class);
    }
}
