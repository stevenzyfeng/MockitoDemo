package com.bytedancer.mockitodemo;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import org.hamcrest.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class StubTests {

    //You can mock concrete classes, not just interfaces
    @Mock
    private LinkedList<String> mMockedList;

    @Test
    public void testStub() {
        //Once stubbed, the method will always return a stubbed value, regardless of how many times it is called.
        //stubbing
        when(mMockedList.get(0)).thenReturn("first");
        when(mMockedList.get(1)).thenThrow(new IndexOutOfBoundsException("Index: 1, Size: 1"));

        //following "first"
        Assert.assertEquals("first", mMockedList.get(0));

        //following throws IndexOutOfBoundsException exception
        try {
            mMockedList.get(1);
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            MatcherAssert.assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 1, Size: 1"));
        }

        //By default, for all methods that return a value, a mock will return either null,
        //a primitive/primitive wrapper value, or an empty collection, as appropriate.
        //following "null" because get(999) was not stubbed
        Assert.assertNull(mMockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed.
        verify(mMockedList).get(0);
        verify(mMockedList).get(1);
        verify(mMockedList).get(999);
    }
}
