package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class IteratorStyleStubTests {

    @Mock
    private LinkedList mMockedList;

    @Test
    public void testIteratorStyleStub() {
        // or you can just use:
        // when(mMockedList.get(0)).thenReturn("one", "two", "three");
        when(mMockedList.get(0)).thenReturn("one")
                .thenReturn("two")
                .thenReturn("three");

        Assert.assertEquals("one", mMockedList.get(0));
        Assert.assertEquals("two", mMockedList.get(0));
        Assert.assertEquals("three", mMockedList.get(0));
    }
}
