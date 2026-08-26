package com.example.debuggingsum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumCalculatorTest {
    @Test public void sumsTwoIntegers() {
        assertEquals(9L, SumCalculator.add("6", "3"));
    }

    @Test public void blankSecondInputCountsAsZero() {
        assertEquals(6L, SumCalculator.add("6", ""));
        assertEquals(6L, SumCalculator.add("6", "   "));
    }

    @Test public void supportsSignedValues() {
        assertEquals(-2L, SumCalculator.add("-5", "3"));
    }

    @Test(expected = NumberFormatException.class)
    public void rejectsNonNumericText() {
        SumCalculator.add("abc", "3");
    }

    @Test(expected = ArithmeticException.class)
    public void detectsOverflow() {
        SumCalculator.add(String.valueOf(Long.MAX_VALUE), "1");
    }
}
