package com.ms.service.impl;

import com.ms.handler.AbstractHandler;
import com.ms.service.SomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SomeServiceImpl implements SomeService {

    public final boolean isTrue() {
        return true;
    }

    @Override
    public String getToday() {
        return AbstractHandler.isHandled("some")
                ? "2022-09-01" : "2022-08-01";
    }
}
