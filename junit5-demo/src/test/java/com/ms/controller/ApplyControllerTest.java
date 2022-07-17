package com.ms.controller;

import com.ms.service.ApplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ApplyService applyService;

    @Test
    public void getAll() {
        // 前提数据库有数据，JUnit5单元测试直接与数据库交互
        assertTrue(applyService.getAll().size() > 0);
    }
}
