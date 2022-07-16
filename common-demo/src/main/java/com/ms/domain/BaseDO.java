package com.ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Id;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseDO {

    /**
     * 主键id
     */
    @Id
    protected Long id;

    /**
     * 备注
     */
    protected String remark;

    /**
     * 软删除标记{@link com.ms.enums.DelFlagEnum}
     */
    protected Integer delFlag;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 创建用户
     */
    protected String createUser;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 更新用户
     */
    protected String updateUser;
}
