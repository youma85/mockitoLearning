package com.youraf.junitcourse;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArraySort() {
		int[] numbers= {12,3,4,2};
		int[] expected= {2,3,4,12};
		Arrays.sort(numbers);
		assertArrayEquals(numbers, expected);
	}

	
	@Test(expected = NullPointerException.class)
	public void testArraySort_nullArray() {
		int[] numbers= null;
		Arrays.sort(numbers);
	}
	
	// timeout in millisecond
	@Test(timeout = 10)
	public void testArraySort_performance() {
		int array[]= {12,23,4};
		for(int i=1;i<1000000;i++) {
			array[0]=i;
			Arrays.parallelSort(array);
		}
	}
}
