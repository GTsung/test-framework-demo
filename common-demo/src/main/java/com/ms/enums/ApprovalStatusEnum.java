package com.ms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ApprovalStatusEnum {

    DEALING(0, "处理中"),

    PASS(1, "通过"),

    REJECT(2, "拒绝"),
    ;

    @Getter
    private Integer code;

    @Getter
    private String desc;
}
