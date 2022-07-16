package com.ms.service;

import com.ms.domain.ApplyDO;

import java.util.List;

public interface ApplyService {

    int saveApply(ApplyDO applyDO);

    List<ApplyDO> getAll();
}
