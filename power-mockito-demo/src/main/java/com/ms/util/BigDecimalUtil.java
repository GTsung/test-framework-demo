package com.ms.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

public abstract class BigDecimalUtil {

    private BigDecimalUtil() {}

    public static final Integer EIGHT = 8;

    public static final Integer TWO = 2;

    public static BigDecimal add(BigDecimal one, BigDecimal two) {
        one = Optional.ofNullable(one).orElse(BigDecimal.ZERO);
        two = Optional.ofNullable(two).orElse(BigDecimal.ZERO);
        return one.add(two);
    }

    public static BigDecimal getScaleVal(BigDecimal original, int scale) {
        if (Objects.isNull(original)) {
            return null;
        }
        if (scale < 0) {
            return original;
        }
        return original.setScale(scale, RoundingMode.HALF_UP);
    }

}
