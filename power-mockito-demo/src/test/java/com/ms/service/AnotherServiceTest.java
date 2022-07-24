package com.ms.service;

import com.ms.domain.ApplyDO;
import com.ms.service.impl.AnotherServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(PowerMockRunner.class)
public class AnotherServiceTest {

    @InjectMocks
    private AnotherServiceImpl anotherService;

    @Test
    public void testCalculate() throws Exception {
        Method method = PowerMockito.method(AnotherServiceImpl.class, "calculate", BigDecimal.class);

        BigDecimal day = new BigDecimal("0.00091600");
        BigDecimal res = (BigDecimal) method.invoke(anotherService, day);
        Assert.assertEquals(res, new BigDecimal("0.02748000"));

    }

    @Test
    public void testConvertTo() throws Exception {
        Method method = PowerMockito.method(AnotherServiceImpl.class, "convertMap", List.class);
        ApplyDO a1 = ApplyDO.builder().period(1).applicant("1").build();
        ApplyDO a2 = ApplyDO.builder().period(2).applicant("2").build();

        List<ApplyDO> applyDOList = new ArrayList<ApplyDO>() {{
            add(a1); add(a2);
        }};

        Map<Integer, ApplyDO> periodApplyMap = (Map<Integer, ApplyDO>) method.invoke(anotherService, applyDOList);
        Assert.assertEquals(2, periodApplyMap.size());
        Assert.assertTrue(periodApplyMap.values().stream().noneMatch(a -> "3".equals(a.getApplicant())));
        Assert.assertTrue(periodApplyMap.values().stream().anyMatch(a -> "1".equals(a.getApplicant())));

    }

}
