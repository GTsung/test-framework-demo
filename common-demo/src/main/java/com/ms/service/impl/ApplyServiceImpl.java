package com.ms.service.impl;

import com.ms.domain.ApplyDO;
import com.ms.manager.ApplyManager;
import com.ms.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyManager applyManager;

    @Override
    public int saveApply(ApplyDO applyDO) {
        return applyManager.save(applyDO);
    }

    @Override
    public List<ApplyDO> getAll() {
        return applyManager.selectAll();
    }
}
