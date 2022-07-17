package com.ms.manager;

import com.ms.dao.ApprovalDao;
import com.ms.domain.ApprovalDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

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
}
