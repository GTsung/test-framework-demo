package com.ms.service;

import com.ms.domain.ApplyDO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private ApplyService applyService;

    @BeforeEach
    void init() {
        // 每次都会插入一条，真实的往数据库中插入数据
        ApplyDO applyDO = ApplyDO.builder()
                .applyCode("001")
                .amount(BigDecimal.ONE)
                .build();
        applyService.saveApply(applyDO);
    }

    @Test
    void testGetAll() {
        List<ApplyDO> applyDOList = applyService.getAll();
        assertTrue(applyDOList.stream().anyMatch(a -> "001".equals(a.getApplyCode())));
    }
}
