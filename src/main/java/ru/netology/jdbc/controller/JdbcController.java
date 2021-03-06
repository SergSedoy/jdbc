package ru.netology.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc.repository.JdbcRepository;

import java.util.List;

@RestController
public class JdbcController {
    private final JdbcRepository repository;

    public JdbcController(JdbcRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> jdbcConnect(@RequestParam ("name") String name) {
        return repository.getProductName(name);
    }
}
