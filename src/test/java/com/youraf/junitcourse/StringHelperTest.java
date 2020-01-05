package com.youraf.junitcourse;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	// test method should be public void
	// each method should test one condition
	@Test
	public void truncateAInFirst2Position_Condition() {
		StringHelper hepler=new StringHelper();
		assertEquals("CD",hepler.truncateAInFirst2Position("AACD"));
	}
	
	@Test
	public void truncateAInFirst2Position_Condition2() {
		StringHelper hepler=new StringHelper();
		assertEquals("CD",hepler.truncateAInFirst2Position("ACD"));
	}


}
