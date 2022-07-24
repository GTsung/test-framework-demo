package com.ms.service.impl;

import com.ms.domain.ApplyDO;
import com.ms.service.AnotherService;
import com.ms.util.BigDecimalUtil;
import org.springframework.stereotype.Service;

import java.util.*;
import java.math.BigDecimal;

@Service
public class AnotherServiceImpl implements AnotherService {

    private static final String A_MONTH_DAYS = "30";

    private BigDecimal calculate(BigDecimal day) {
        return BigDecimalUtil.getScaleVal(
                day.multiply(new BigDecimal(A_MONTH_DAYS)),
                BigDecimalUtil.EIGHT);
    }

    private Map<Integer, ApplyDO> convertMap(List<ApplyDO> applyDOList) {
        return applyDOList.stream()
                .collect(HashMap::new,
                        (map, apply) -> map.put(apply.getPeriod(), apply),
                        HashMap::putAll);

    }
}
