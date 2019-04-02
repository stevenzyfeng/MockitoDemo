package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.*;
import org.mockito.*;

public class VerifyTestsWithMockitoAnnotations {

    // MockitoAnnotations.initMocks(this); initializes fields annotated with Mockito annotations
    @Before
    public void setUpClass() {
        MockitoAnnotations.initMocks(this);
    }

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
