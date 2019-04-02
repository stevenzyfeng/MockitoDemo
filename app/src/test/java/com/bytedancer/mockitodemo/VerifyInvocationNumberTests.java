package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class VerifyInvocationNumberTests {

    @Mock
    private LinkedList mMockedList;

    @Test
    public void verifyInvocationNumberTests() {

        //using mock
        mMockedList.add("once");

        mMockedList.add("twice");
        mMockedList.add("twice");

        mMockedList.add("three times");
        mMockedList.add("three times");
        mMockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mMockedList).add("once");
        verify(mMockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mMockedList, times(2)).add("twice");
        verify(mMockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mMockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mMockedList, atLeastOnce()).add("three times");
        verify(mMockedList, atLeast(2)).add("three times");
        verify(mMockedList, atMost(5)).add("three times");
    }
}
