package com.youraf.mockito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void listSizeMock() {
		List listMock= mock(List.class);
		// when you want to get the size then you will have 2
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void listSizeMock_ReturnMultipleValues() {
		List listMock= mock(List.class);
		// first time return 2 second time returns 3
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	public void listGetValues() {
		List listMock= mock(List.class);
		when(listMock.get(0)).thenReturn("youraf");
		assertEquals("youraf", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	public void listGetValues_withMatcher() {
		List listMock= mock(List.class);
		// anyInt: Argument Matcher
		// if the .get is called with any int or null then we will have youraf as result
		when(listMock.get(anyInt())).thenReturn("youraf");
		assertEquals("youraf", listMock.get(0));
		assertEquals("youraf", listMock.get(8999));
	}
	
	@Test(expected = RuntimeException.class)
	public void listGetValues_throwAnException() {
		List listMock= mock(List.class);
		// anyInt: Argument Matcher
		// if the .get is called with any int or null then we will have youraf as result
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something happened"));
		listMock.get(0);
	}

}
