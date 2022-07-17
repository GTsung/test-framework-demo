package com.ms.service;

import com.ms.domain.ApplyDO;
import com.ms.domain.ApprovalDO;
import com.ms.manager.ApplyManager;
import com.ms.manager.ApprovalManager;
import com.ms.service.impl.ApprovalServiceImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

public class ApprovalServiceTest {

    @Mock
    private ApprovalManager approvalManager;

    @Mock
    private ApplyManager applyManager;

    @InjectMocks
    private ApprovalServiceImpl approvalService;

    @Before
    public void setUp() {
        approvalManager = Mockito.mock(ApprovalManager.class);
        applyManager = Mockito.mock(ApplyManager.class);
        approvalService = Mockito.mock(ApprovalServiceImpl.class);
        MockitoAnnotations.initMocks(this);
    }

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
        Assert.assertEquals(applicant, result.getApplicant());
        Assert.assertEquals(creditLine, result.getCreditLine());

    }

}
