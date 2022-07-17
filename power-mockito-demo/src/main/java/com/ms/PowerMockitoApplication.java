package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@MapperScan(basePackages = {"com.ms.dao"})
@SpringBootApplication
public class PowerMockitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerMockitoApplication.class, args);
    }

}


