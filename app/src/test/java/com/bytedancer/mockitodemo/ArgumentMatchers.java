package com.bytedancer.mockitodemo;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.argThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatchers {

    //You can mock concrete classes, not just interfaces
    @Mock
    private LinkedList mMockedList;

    @Test
    public void testArgumentMatchers() {

        //stubbing using built-in anyInt() argument matcher
        when(mMockedList.get(anyInt())).thenReturn("element");
        //stubbing using custom matcher
        when(mMockedList.addAll(argThat(new ListOfTwoElements()))).thenReturn(true);

        //following "element"
        Assert.assertEquals("element", mMockedList.get(999));
        //following true
        Assert.assertTrue(mMockedList.addAll(Arrays.asList("one", "two")));

        //you can also verify using an argument matcher
        verify(mMockedList).get(anyInt());
        verify(mMockedList).addAll(argThat(new ListOfTwoElements()));
    }

    class ListOfTwoElements implements ArgumentMatcher<List> {

        public boolean matches(List list) {
            return list.size() == 2;
        }

        public String toString() {
            //printed in verification errors
            return "[list of 2 elements]";
        }
    }
}

