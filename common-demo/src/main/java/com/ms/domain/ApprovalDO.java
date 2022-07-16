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
@Table(name = "approval")
public class ApprovalDO extends BaseDO {

    private String approvalCode;

    private String applicant;

    private BigDecimal creditLine;

    private String reason;

    private Date applyDate;

    /**
     * @see com.ms.enums.ApprovalStatusEnum
     */
    private Integer status;

    private Integer period;

    private BigDecimal rate;

    private String repayWay;

    private Long applicationId;

    private String applyCode;
}
