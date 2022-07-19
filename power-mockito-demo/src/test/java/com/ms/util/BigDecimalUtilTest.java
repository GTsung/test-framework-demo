package com.ms.util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalUtilTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(BigDecimal.ZERO, BigDecimalUtil.add(null, null));
    }
}
