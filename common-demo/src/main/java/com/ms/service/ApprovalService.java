package com.ms.service;

import com.ms.domain.ApprovalDO;

import java.util.List;

public interface ApprovalService {

    ApprovalDO getByApplyCode(String applyCode);

    List<ApprovalDO> getByApplyCodes(List<String> applyCodes);
}
