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

}
