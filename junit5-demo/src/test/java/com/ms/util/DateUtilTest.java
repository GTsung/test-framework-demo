package com.ms.util;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilTest {

    @Test
    public void testCalcDayOffset() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
        Date start = dateFormat.parse("2019-01-09 15:33:44");
        Date end = dateFormat.parse("2019-01-13 00:00:00");
        int offset1 = DateUtil.calcDayOffset(start, end);
//        Date startLastYear = dateFormat.parse("2018-12-20 22:22:00");
//        int offset2 = DateUtil.calcDayOffset(startLastYear, end);

        assert offset1 == 4;

    }
}
