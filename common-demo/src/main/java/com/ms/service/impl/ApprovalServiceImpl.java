package com.ms.service.impl;

import com.ms.dao.ApprovalDao;
import com.ms.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalDao approvalDao;


}
