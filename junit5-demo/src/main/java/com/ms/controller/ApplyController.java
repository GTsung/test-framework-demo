package com.ms.controller;

import com.ms.domain.ApplyDO;
import com.ms.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @PostMapping("/save")
    public int save(@RequestBody ApplyDO applyDO) {
        return applyService.saveApply(applyDO);
    }
}
