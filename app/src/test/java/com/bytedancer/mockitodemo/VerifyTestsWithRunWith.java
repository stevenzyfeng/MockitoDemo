package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

// use MockitoJUnit4Runner as a JUnit runner
@RunWith(MockitoJUnitRunner.class)
public class VerifyTestsWithRunWith {

    // mock creation
    // In reality, please don't mock the List class. Use a real instance instead.
    @Mock
    private List<String> mMockedList;

    // Once created, a mock will remember all interactions.
    // Then you can selectively verify whatever interactions you are interested in.
    @Test
    public void verifyMethodCall() {
        // using mock object
        mMockedList.add("one");
        mMockedList.clear();

        // verification
        verify(mMockedList).add("one");
        verify(mMockedList).clear();
    }
}
