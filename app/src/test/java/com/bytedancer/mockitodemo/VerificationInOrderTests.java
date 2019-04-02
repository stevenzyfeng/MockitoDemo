package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class VerificationInOrderTests {

    // A. Single mock whose methods must be invoked in a particular order
    @Mock
    private List mSingleMock;

    // B. Multiple mocks that must be used in a particular order
    @Mock
    private List mFirstMock;
    @Mock
    private List mSecondMock;

    @Test
    public void testVerificationInOrder() {

        //using a single mock
        mSingleMock.add("was added first");
        mSingleMock.add("was added second");

        //create an inOrder verifier for a single mock
        InOrder inSingleOrder = inOrder(mSingleMock);

        //following will make sure that add is first called with "was added first", then with "was added second"
        inSingleOrder.verify(mSingleMock).add("was added first");
        inSingleOrder.verify(mSingleMock).add("was added second");

        //using mocks
        mFirstMock.add("was called first");
        mSecondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        InOrder inMultipleOrder = inOrder(mFirstMock, mSecondMock);

        //following will make sure that mFirstMock was called before secondMock
        inMultipleOrder.verify(mFirstMock).add("was called first");
        inMultipleOrder.verify(mSecondMock).add("was called second");
    }
}
