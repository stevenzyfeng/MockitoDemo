package com.bytedancer.mockitodemo;

import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class BehaviorDrivenDevelopmentTests {

    private MathApplication mMathApplication;
    private CalculatorService mCalcService;

    @Before
    public void setUp() {
        mMathApplication = new MathApplication();
        mCalcService = mock(CalculatorService.class);
        mMathApplication.setCalculatorService(mCalcService);
    }

    @Test
    public void testVerificationTimeout() {
        //add the behavior to add numbers
        when(mCalcService.add(20.0, 10.0)).thenReturn(30.0);

        //subtract the behavior to subtract numbers
        when(mCalcService.subtract(20.0, 10.0)).thenReturn(10.0);

        //test the subtract functionality
        Assert.assertEquals(10.0, mMathApplication.subtract(20.0, 10.0), 0);

        //test the add functionality
        Assert.assertEquals(30.0, mMathApplication.add(20.0, 10.0), 0);

        //verify call to add method to be completed within 100 ms
        verify(mCalcService, timeout(100)).add(20.0, 10.0);

        //invocation count can be added to ensure multiplication invocations
        //can be checked within given times
        verify(mCalcService, timeout(100).times(1)).subtract(20.0, 10.0);
    }

    public interface CalculatorService {

        public double add(double input1, double input2);

        public double subtract(double input1, double input2);
    }

    public class MathApplication {

        private CalculatorService calcService;

        public void setCalculatorService(CalculatorService calcService) {
            this.calcService = calcService;
        }

        public double add(double input1, double input2) {
            return calcService.add(input1, input2);
        }

        public double subtract(double input1, double input2) {
            return calcService.subtract(input1, input2);
        }

    }
}
