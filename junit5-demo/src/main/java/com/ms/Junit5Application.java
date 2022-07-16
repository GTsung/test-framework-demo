package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = {"com.ms.dao"})
public class Junit5Application {

    public static void main(String[] args) {
        SpringApplication.run(Junit5Application.class, args);
    }
}
