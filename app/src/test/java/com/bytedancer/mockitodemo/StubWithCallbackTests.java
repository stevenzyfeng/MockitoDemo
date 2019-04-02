package com.bytedancer.mockitodemo;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.invocation.*;
import org.mockito.junit.*;
import org.mockito.stubbing.*;

@RunWith(MockitoJUnitRunner.class)
public class StubWithCallbackTests {

    @Rule
    public final TestName mName = new TestName();

    @Mock
    private LinkedList mLinkedList;

    // Warning: The need to use a custom answer may indicate
    // that tested code is too complicated and should be re-factored.
    @Test
    public void testStubWithCallback() {

        when(mLinkedList.get(anyInt())).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocation) {
                        Object[] args = invocation.getArguments();
                        Object mock = invocation.getMock();
                        return mock + " called " + mName.getMethodName() + "with arguments: " + Arrays.toString(args);
                    }
                });

        //Following prints "called with arguments: [0]"
        System.out.println(mLinkedList.get(0));
    }
}
