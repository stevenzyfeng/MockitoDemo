package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.*;

public class SpyingOnRealObjectsTests {

    @Test
    public void testSpyingOnRealObjects() {
        List list = new LinkedList();
        List spy = spy(list);

        // optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        // using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        // Mockito *does not* delegate calls to the passed real instance,
        // instead it actually creates a copy of it.
        // Assert.assertEquals("one", list.get(0));
        // Assert.assertEquals(100, list.size());

        // "one" - the first element of a list
        Assert.assertEquals("one", spy.get(0));

        // size() method was stubbed - 100 is printed
        Assert.assertEquals(100, spy.size());

        // optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
    }

    @Test
    public void testRealPartialMocks() {
        // you can create partial mock with spy() method
        List list = spy(new LinkedList());

        // optionally, you can stub out some methods:
        when(list.size()).thenReturn(100);

        // using the spy calls *real* methods
        list.add("one");
        list.add("two");

        Assert.assertEquals("one", list.get(0));
        Assert.assertEquals(100, list.size());

        // optionally, you can verify
        verify(list).add("one");
        verify(list).add("two");
    }
}
