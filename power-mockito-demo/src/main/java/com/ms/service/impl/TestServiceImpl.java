package com.ms.service.impl;

import com.ms.domain.ApplyDO;
import com.ms.domain.ApprovalDO;
import com.ms.service.ApplyService;
import com.ms.service.ApprovalService;
import com.ms.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private ApplyService applyService;

    @Override
    public List<ApprovalDO> getAllApprovalDOS() {
        List<ApplyDO> applyDOList = applyService.getAll();
        return approvalService.getByApplyCodes(
                applyDOList.stream().map(ApplyDO::getApplyCode)
                        .collect(Collectors.toList()));
    }

    private List<ApplyDO> getAllApplyDOS() {
        return applyService.getAll();
    }
}
