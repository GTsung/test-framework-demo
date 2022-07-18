package com.ms.service;

import com.ms.domain.ApplyDO;
import com.ms.domain.ApprovalDO;
import com.ms.manager.ApplyManager;
import com.ms.manager.ApprovalManager;
import com.ms.service.impl.ApprovalServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest // 可以使用注解SpringBootTest，内部自动将配置文件中的扩展类MockitoExtension引进来
//@ExtendWith(MockitoExtension.class) // 也可以单独使用此注解将MockitoExtension扩展进来
public class ApprovalServiceTest {

    @Mock
    private ApprovalManager approvalManager;

    @Mock // 被测试类所依赖的
    private ApplyManager applyManager;

    @InjectMocks // 被测试的service
    private ApprovalServiceImpl approvalService;

    /**
     * 以下这种在JUnit4中使用，在@Before中将类mock，
     * 顺便 MockitoAnnotations.initMocks(this)---> 这个方法Mockito3.+已经过期
     */

//    @BeforeEach
//    public void init() {
//        approvalManager = Mockito.mock(ApprovalManager.class);
//        applyManager = Mockito.mock(ApplyManager.class);
//        autoCloseable = MockitoAnnotations.initMocks(this);
//    }


    @Test
    public void testGetByApplyCode() {
        String applyCode = "01";
        String approvalCode = "02";
        String applicant = "Adams";
        BigDecimal creditLine = BigDecimal.TEN;

        // stub
        ApplyDO applyDO = ApplyDO.builder()
                .applyCode(applyCode).approvalCode(approvalCode)
                .build();
        Mockito.when(applyManager.getByApplyCode(applyCode)).thenReturn(applyDO);

        ApprovalDO approvalDO = ApprovalDO.builder()
                .approvalCode(approvalCode).applicant(applicant)
                .creditLine(creditLine).build();
        Mockito.when(approvalManager.getByApprovalCode(approvalCode))
                .thenReturn(approvalDO);

        // assert result
        ApprovalDO result = approvalService.getByApplyCode(applyCode);
        assertEquals(applicant, result.getApplicant());
        assertEquals(creditLine, result.getCreditLine());

    }

}
