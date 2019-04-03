package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import org.junit.*;
import org.mockito.*;

public class DefaultReturnValuesTests {

    //java.lang.AssertionError, if
    //LinkedList mockedList = mock(LinkedList.class);
    LinkedList mockedList = mock(LinkedList.class, Mockito.RETURNS_SMART_NULLS);

    @Test
    public void testDefaultReturnValues() {
        Assert.assertNotNull(mockedList.get(0));
    }
}
