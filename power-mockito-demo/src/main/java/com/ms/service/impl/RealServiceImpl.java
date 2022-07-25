package com.ms.service.impl;

import com.ms.domain.ApplyDO;
import com.ms.service.ApplyService;
import com.ms.service.RealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealServiceImpl implements RealService {

    @Autowired
    private ApplyService applyService;

    @Override
    public ApplyDO assemble() {
        ApplyDO applyDO = new ApplyDO();
        applyDO = applyService.assemble(applyDO);
        return applyDO;
    }
}
