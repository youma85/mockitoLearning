package com.youraf.junitcourse;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
	
	StringHelper hepler=new StringHelper();
	
	private String input;
	private String expectedOutput;
	
	// will be executed twice to fill the attribute
	public StringHelperParameterizedTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	// static method that contains the parameters
	@Parameters
	public static Collection<String[]> testConditions() {
		String expetedOutputs[][] = {
			{"AACD","CD"},
			{"ACD","CD"}
		};
		return Arrays.asList(expetedOutputs);
	}
	
	// this test will be executed twice depending on the parameters
	@Test
	public void truncateAInFirst2Positions() {
		assertEquals(expectedOutput,hepler.truncateAInFirst2Position(input));
	}
}
