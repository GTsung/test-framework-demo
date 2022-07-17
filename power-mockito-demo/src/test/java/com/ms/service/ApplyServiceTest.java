package com.ms.service;

import com.ms.domain.ApplyDO;
import com.ms.manager.ApplyManager;
import com.ms.service.impl.ApplyServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

@RunWith(PowerMockRunner.class)
public class ApplyServiceTest {

    @Mock
    private ApplyManager applyManager;

    @InjectMocks
    private ApplyServiceImpl applyService;

    @Before
    public void init() {
        applyManager = Mockito.mock(ApplyManager.class);
        applyService = Mockito.mock(ApplyServiceImpl.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<ApplyDO> applyDOList = Lists.newArrayList();
        applyDOList.add(ApplyDO.builder().applyCode("1").build());
        applyDOList.add(ApplyDO.builder().applyCode("2").build());
        applyDOList.add(ApplyDO.builder().applyCode("3").build());

        Mockito.when(applyManager.selectAll()).thenReturn(applyDOList);

        Assert.assertEquals(3, applyService.getAll().size());
    }
}
