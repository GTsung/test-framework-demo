package com.ms.controller;

import com.ms.domain.ApprovalDO;
import com.ms.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @GetMapping("/getByApplyCode/{code}")
    public ApprovalDO getByApplyCode(@PathVariable("code") String code) {
        return approvalService.getByApplyCode(code);
    }
}
