package com.ms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StageEnum {

    APPLYING(0, "申请中"),

    ;


    @Getter
    private Integer code;

    @Getter
    private String desc;
}
