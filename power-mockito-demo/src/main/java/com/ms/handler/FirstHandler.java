package com.ms.handler;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FirstHandler extends AbstractHandler {

    @PostConstruct
    public void init() {
        super.register("first", this);
    }

    @Override
    public boolean finish(String key) {
        return false;
    }
}
