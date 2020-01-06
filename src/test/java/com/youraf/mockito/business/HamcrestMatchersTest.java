package com.youraf.mockito.business;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> scores=Arrays.asList(89,100,110,79);
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItem(79));
		assertThat(scores, everyItem(greaterThan(75)));
		assertThat(scores, everyItem(lessThan(150)));
		
		// String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		// Arrays
		Integer[] marks= {1,2,3};
		assertThat(marks, arrayWithSize(3));
		assertThat(marks, arrayContaining(1,2,3));
		assertThat(marks, arrayContainingInAnyOrder(1,2,3));
	}

}

