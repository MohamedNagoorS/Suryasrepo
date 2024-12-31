package com.example.automation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {
    @Test
    public void testGenerateSeries() {
        Fibonacci fibonacci = new Fibonacci();
        int[] series = fibonacci.generateSeries(5);
        assertArrayEquals(new int[]{0, 1, 1, 2, 3}, series);

        series = fibonacci.generateSeries(0);
        assertArrayEquals(new int[]{}, series);
    }

    @Test
    public void testGetNthFibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(0, fibonacci.getNthFibonacci(1));
        assertEquals(1, fibonacci.getNthFibonacci(2));
        assertEquals(1, fibonacci.getNthFibonacci(3));
        assertEquals(2, fibonacci.getNthFibonacci(4));
        assertEquals(3, fibonacci.getNthFibonacci(5));
    }

    @Test
    public void duplicateTest1() {
        Fibonacci fibonacci = new Fibonacci();
        int[] series = fibonacci.generateSeries(7);
        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8}, series);
    }

    @Test
    public void duplicateTest2() {
        Fibonacci fibonacci = new Fibonacci();
        int[] series = fibonacci.generateSeries(7);
        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8}, series);
    }
}
