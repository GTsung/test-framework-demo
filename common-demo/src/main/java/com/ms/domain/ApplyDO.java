package com.ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apply")
public class ApplyDO extends BaseDO {

    private String applyCode;

    private String approvalCode;

    /**
     * @see com.ms.enums.StageEnum
     */
    private Integer stage;

    private String applicant;

    private String idCardNumber;

    private String phoneNumber;

    private String companyName;

    private BigDecimal amount;

    private String reason;

    private Date applyDate;

    /**
     * @see com.ms.enums.ApprovalStatusEnum
     */
    private Integer status;

    private Integer period;

    private BigDecimal rate;

}
