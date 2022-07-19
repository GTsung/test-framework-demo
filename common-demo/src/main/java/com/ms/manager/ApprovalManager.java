package com.ms.manager;

import com.google.common.collect.Lists;
import com.ms.dao.ApprovalDao;
import com.ms.domain.ApprovalDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class ApprovalManager extends BaseManager<ApprovalDO> {

    @Autowired
    private ApprovalDao approvalDao;

    public ApprovalDO getByApprovalCode(String approvalCode) {
        if (StringUtils.isBlank(approvalCode)) {
            return null;
        }
        Example example = new Example(ApprovalDO.class);
        example.and().andEqualTo("approvalCode", approvalCode);
        return approvalDao.selectOneByExample(example);
    }

    public List<ApprovalDO> getByApplyCodes(List<String> applyCodes) {
        if (CollectionUtils.isEmpty(applyCodes)) {
            return Lists.newArrayList();
        }
        Example example = new Example(ApprovalDO.class);
        example.and().andIn("applyCode", applyCodes);
        return approvalDao.selectByExample(example);
    }
}
