package com.ms.service;


import com.ms.handler.AbstractHandler;
import com.ms.service.impl.SomeServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SomeServiceImpl.class, AbstractHandler.class})
public class SomeServiceTest {

    @InjectMocks
    private SomeServiceImpl someService;

    @Test
//    @PrepareForTest({SomeServiceImpl.class})
    public void testIsTrue() {
        // mock final method
        // 当这个类中有其他方法使用@PrepareForTest注解时，这个final方法对应的类也应该加入到注解中
        Assert.assertTrue(someService.isTrue());
    }

    @Test
//    @PrepareForTest({AbstractHandler.class})
    public void getToday() throws Exception {
        // mock static 需要加注解@PrepareForTest并指定类，另外需要PowerMockito.mockStatic(xxx.class)
        PowerMockito.mockStatic(AbstractHandler.class);
        PowerMockito.when(AbstractHandler.class, "isHandled", Mockito.any()).thenReturn(true);
        String date = "2022-09-01";
        Assert.assertEquals(date, someService.getToday());
    }

}
