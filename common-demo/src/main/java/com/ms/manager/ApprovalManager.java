package com.ms.manager;

import com.ms.dao.ApprovalDao;
import com.ms.domain.ApprovalDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApprovalManager extends BaseManager<ApprovalDO> {

    @Autowired
    private ApprovalDao approvalDao;



}
