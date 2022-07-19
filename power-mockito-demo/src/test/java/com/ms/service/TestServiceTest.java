package com.ms.service;

import com.ms.domain.ApplyDO;
import com.ms.domain.ApprovalDO;
import com.ms.service.impl.ApplyServiceImpl;
import com.ms.service.impl.ApprovalServiceImpl;
import com.ms.service.impl.TestServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class TestServiceTest {

    @Mock
    private ApprovalServiceImpl approvalService;

    @Mock
    private ApplyServiceImpl applyService;

    @InjectMocks
    private TestServiceImpl testService;

    @Before
    public void setUp() {
        applyService = Mockito.mock(ApplyServiceImpl.class);
        approvalService = Mockito.mock(ApprovalServiceImpl.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllApprovalDOS() {
        List<ApplyDO> applyDOList = new ArrayList<ApplyDO>() {{
            add(ApplyDO.builder().applyCode("01").applicant("gt-01").build());
            add(ApplyDO.builder().applyCode("02").applicant("gt-02").build());
            add(ApplyDO.builder().applyCode("03").applicant("gt-03").build());
        }};

        Mockito.when(applyService.getAll()).thenReturn(applyDOList);

        List<String> applyCodes = new ArrayList<String>() {{
            add("01");
            add("02");
            add("03");
        }};

        List<ApprovalDO> approvalDOS = new ArrayList<ApprovalDO>() {{
            add(ApprovalDO.builder().approvalCode("FUCK-01").build());
            add(ApprovalDO.builder().approvalCode("FUCK-02").build());
            add(ApprovalDO.builder().approvalCode("FUCK-03").build());
        }};

        Mockito.when(approvalService.getByApplyCodes(applyCodes)).thenReturn(approvalDOS);

        List<ApprovalDO> result = testService.getAllApprovalDOS();
        Assert.assertTrue(result.stream().anyMatch(r -> "FUCK-01".equals(r.getApprovalCode())));
        Assert.assertTrue(result.stream().anyMatch(r -> "FUCK-02".equals(r.getApprovalCode())));
        Assert.assertFalse(result.stream().anyMatch(r -> "FUCK-04".equals(r.getApprovalCode())));
    }

    @Test
    public void testGetAllApplyDOS() throws Exception {
        List<ApplyDO> applyDOList = new ArrayList<ApplyDO>() {{
            add(ApplyDO.builder().applicant("11").build());
            add(ApplyDO.builder().applicant("22").build());
            add(ApplyDO.builder().applicant("33").build());
        }};

        Mockito.when(applyService.getAll()).thenReturn(applyDOList);

        // 不同于Mockito需要将私有方法改为公有方法，PowerMock可以直接mock私有方法
        // Whitebox.invokeMethod() ---> 私有方法
        // Whitebox.invokeConstructor() ---> 私有构造方法
        // Whitebox.getInternalState() ---> 私有属性
        // and so on ...
        List<ApplyDO> result = Whitebox.invokeMethod(testService, "getAllApplyDOS");
        Assert.assertTrue(result.stream().noneMatch(r -> "44".equals(r.getApplicant())));
        Assert.assertTrue(result.stream().anyMatch(r -> "33".equals(r.getApplicant())));
        Assert.assertTrue(result.stream().anyMatch(r -> "22".equals(r.getApplicant())));
        Assert.assertTrue(result.stream().anyMatch(r -> "11".equals(r.getApplicant())));

    }
}
