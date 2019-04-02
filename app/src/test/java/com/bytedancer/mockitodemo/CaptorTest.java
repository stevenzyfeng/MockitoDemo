package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class CaptorTest {

    class MathUtils {

        public int add(int x, int y) {
            return x + y;
        }
    }

    @Mock
    MathUtils mMockMathUtils;

    @Test
    public void testCaptor() {
        when(mMockMathUtils.add(1, 1)).thenReturn(2);

        ArgumentCaptor acInteger = ArgumentCaptor.forClass(Integer.class);

        Assert.assertEquals(2, mMockMathUtils.add(1, 1));

        verify(mMockMathUtils).add((int) acInteger.capture(), (int) acInteger.capture());
        List allValues = acInteger.getAllValues();

        Assert.assertEquals(Arrays.asList(1, 1), allValues);
    }
}
