package com.ms.service;

import com.ms.domain.ApprovalDO;

public interface ApprovalService {

    ApprovalDO getByApplyCode(String applyCode);
}
