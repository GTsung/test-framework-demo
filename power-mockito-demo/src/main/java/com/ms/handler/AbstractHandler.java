package com.ms.handler;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public abstract class AbstractHandler {

    private static final Map<String, AbstractHandler> MAP = new ConcurrentHashMap<>();

    protected void register(String key, AbstractHandler handler) {
        MAP.put(key, handler);
    }

    abstract public boolean finish(String key);

    public static final boolean isHandled(String key) {
        AbstractHandler handler = MAP.get(key);
        if (Objects.isNull(handler)) {
            return true;
        }
        return handler.finish(key);
    }
}
