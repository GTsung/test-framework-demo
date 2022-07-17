package com.ms.simple;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test() {
        // mock创建
        List<String> mockedList = Mockito.mock(List.class);

        mockedList.add("one");

        mockedList.clear();

        // verify验证是否发生了某些行为，为确保是否真正调用了预想的方法，
        // 还可以用来验证某个方法调用的次数
        Mockito.verify(mockedList).add("one");

        Mockito.verify(mockedList).clear();

    }

    @Test
    public void test2() {
        LinkedList mockList = Mockito.mock(LinkedList.class);

        // Mockito.when(condition).thenReturn(result)
        // ---> 打桩，即预先规定遇到某个条件后返回某个结果，可以用于模拟依赖
        Mockito.when(mockList.get(0)).thenReturn("first");

        assertEquals("first", mockList.get(0));
    }

}
