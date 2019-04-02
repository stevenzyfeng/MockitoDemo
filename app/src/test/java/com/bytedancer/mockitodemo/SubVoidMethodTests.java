package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class SubVoidMethodTests {

    @Mock
    private LinkedList mMockedList;

    @Test
    public void testSubVoidMethod() {

        // Stubbing void methods requires a different approach from when(Object)
        // because the compiler does not like void methods inside brackets...
        doThrow(new RuntimeException()).when(mMockedList).clear();

        //following throws RuntimeException:
        try {
            mMockedList.clear();
        } catch (RuntimeException runtimeException) {
            Assert.assertNotNull(runtimeException);
        }
    }
}
