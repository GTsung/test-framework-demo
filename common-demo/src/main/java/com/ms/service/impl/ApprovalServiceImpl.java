package com.ms.service.impl;

import com.ms.domain.ApplyDO;
import com.ms.domain.ApprovalDO;
import com.ms.manager.ApplyManager;
import com.ms.manager.ApprovalManager;
import com.ms.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalManager approvalManager;

    @Autowired
    private ApplyManager applyManager;

    @Override
    public ApprovalDO getByApplyCode(String applyCode) {
        ApplyDO applyDO = applyManager.getByApplyCode(applyCode);
        if (Objects.isNull(applyDO)) {
            return null;
        }
        return approvalManager.getByApprovalCode(applyDO.getApprovalCode());
    }

    @Override
    public List<ApprovalDO> getByApplyCodes(List<String> applyCodes) {
        return approvalManager.getByApplyCodes(applyCodes);
    }

}
