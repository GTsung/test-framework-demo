package com.ms.domain;

import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;

public class DynamicTest {

    private final Calculator calculator = new Calculator();

    @TestFactory
    List<String> dynamicTestsWithInvalidReturnType() {
        // failed
        return Arrays.asList("Hello");
    }



}
