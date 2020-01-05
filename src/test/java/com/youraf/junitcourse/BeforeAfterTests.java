package com.youraf.junitcourse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAfterTests {
	
	StringHelper helper;
	// method beforeClass should be static
	// init static objects
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Execute once before");
	}
	
	// will be executed before each method
	@Before
	public void setup() {
		System.out.println("Before All tests");
		helper=new StringHelper();
	}

	@Test
	public void test() {
		System.out.println("test 1 executed");
	}
	
	@Test
	public void test2() {
		System.out.println("test 2 executed");
	}

	@After
	public void tearDown() {
		System.out.println("After All tests");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class executed once");
	}

}
