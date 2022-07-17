package com.ms.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 引用的是JUnit4的包  org.junit.Test
 */
public class DateUtilJunit4Test {

    @Test
    public void test() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
        Date start = dateFormat.parse("2019-01-09 15:33:44");
        Date end = dateFormat.parse("2019-01-13 00:00:00");
        int offset1 = DateUtil.calcDayOffset(start, end);
        assert offset1 == 4;

    }
}
