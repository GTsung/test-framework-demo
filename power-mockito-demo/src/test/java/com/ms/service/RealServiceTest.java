package com.ms.service;

import com.ms.domain.ApplyDO;
import com.ms.manager.ApplyManager;
import com.ms.service.impl.ApplyServiceImpl;
import com.ms.service.impl.RealServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class RealServiceTest {

    @Mock
    private ApplyServiceImpl applyService;
    @Mock
    private ApplyManager applyManager;
    @InjectMocks
    private RealServiceImpl realService;

    @Before
    public void setUp() {
        applyService = Mockito.mock(ApplyServiceImpl.class);
        applyManager = Mockito.mock(ApplyManager.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAssemble() {
        ApplyDO applyDO = new ApplyDO();
        PowerMockito.doCallRealMethod().when(applyService).assemble(applyDO);
        PowerMockito.doCallRealMethod().when(applyManager).save(applyDO);
        applyDO = realService.assemble();
        Assert.assertEquals("fuck", applyDO.getApplicant());
    }
}
