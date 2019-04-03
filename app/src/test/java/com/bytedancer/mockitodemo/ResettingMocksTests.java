package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.*;
import org.mockito.*;

public class ResettingMocksTests {

    @Test
    public void testResettingMocks() {
        List mock = mock(List.class);

        when(mock.size()).thenReturn(10);
        when(mock.get(0)).thenReturn(1);

        Assert.assertEquals(1, mock.get(0));
        Assert.assertEquals(10, mock.size());

        //First potential code smell is reset() in the middle of the test method.
        Mockito.reset(mock);
        //at this point the mock forgot any interactions & stubbing
        //Assert.assertEquals(1, mock.get(0));
        //Assert.assertEquals(10, mock.size());
    }
}
