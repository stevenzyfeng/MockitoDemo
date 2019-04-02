package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.*;

public class VerifyTests {

    // Once created, a mock will remember all interactions.
    // Then you can selectively verify whatever interactions you are interested in.
    @Test
    public void verifyMethodCall() {
        // mock creation
        // In reality, please don't mock the List class. Use a real instance instead.
        List<String> mockedList = mock(List.class);

        // using mock object
        mockedList.add("one");
        mockedList.clear();

        // verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
