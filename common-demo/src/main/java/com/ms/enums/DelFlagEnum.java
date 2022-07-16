package com.ms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DelFlagEnum {

    PERSISTENT(0, "未删除"),

    DELETED(1, "已删除"),
    ;

    @Getter
    private Integer code;

    @Getter
    private String desc;

}
