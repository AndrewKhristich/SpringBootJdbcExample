package com.example.demo;

import com.example.demo.repository.DataBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private JdbcTemplate jdbcTemplate;
    private DataBaseRepository repository;


    @Autowired
    public DemoApplication(JdbcTemplate jdbcTemplate, DataBaseRepository repository) {
        this.jdbcTemplate = jdbcTemplate;
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DROP TABLE IF EXISTS `line_table`");
        jdbcTemplate.execute("CREATE  TABLE `public`.`line_table` (" +
                "  `id` BIGINT NOT NULL AUTO_INCREMENT ," +
                "  `line_name` VARCHAR(255) NOT NULL ," +
                "  PRIMARY KEY (`id`) )");

        repository.addOneLineByName("asd");
        repository.addOneLineByName("asd1");
        repository.addOneLineByName("asd2");
        repository.addOneLineByName("asd");
        repository.addOneLineByName("asd");
    }
}
