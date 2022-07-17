package com.ms.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(2, calculator.add(1, 1));
    }

    @RepeatedTest(value = 2)
    void repeated() {
        // 重复执行测试
        assertEquals(3, calculator.add(2, 1));
    }

    @BeforeAll
    static void initAll() {
        // 执行测试方法首先被调用,只会调用一次,无论单元测试是否失败
        System.out.println("beforeAll-----initAll");
    }

    @BeforeEach
    void init() {
        // 执行测试方法首先被调用，每次执行其他测试方法时都会被调用
        System.out.println("beforeEach----init");
    }

    @AfterEach
    void tearDown() {
        System.out.println("afterEach---tearDown");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("afterAll----tearDownAll");
    }


    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = "true")
    void only() {
        // 属性为true时才会执行
    }

    @Test
    @EnabledIf(value = "customCondition") // 如果表达式不在本类中，需要这个方法为static而且引用需方法的全路径
//    @EnabledIf(value = "xx.xx#customCondition")
    void enabled() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @DisabledIf(value = "customCondition")
    void disable() {
        assertEquals(2, calculator.add(1, 1));
    }

    boolean customCondition() {
        return true;
    }

    // @Order(1) 指定顺序
    // @Tag("") 方便过滤

    @ParameterizedTest // 传递参数
    @MethodSource("provider")
    void testMethod(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> provider() {
        return Stream.of("apple", "banana");
    }
}

