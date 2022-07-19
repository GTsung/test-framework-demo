package com.ms.util;

import java.math.BigDecimal;
import java.util.Optional;

public abstract class BigDecimalUtil {

    private BigDecimalUtil() {}

    public static BigDecimal add(BigDecimal one, BigDecimal two) {
        one = Optional.ofNullable(one).orElse(BigDecimal.ZERO);
        two = Optional.ofNullable(two).orElse(BigDecimal.ZERO);
        return one.add(two);
    }
}
