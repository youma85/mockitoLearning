package com.youraf.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.youraf.mockito.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void retrieveTodosRelatedToSpring_usingMock() {
		// create a mock object of todoService
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos=Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn Angular");
		
		// when call the method retrieve with this parameter return back a todoList
		// Enables stubbing methods. Use it when you want the mock to return particular value when particular method is called.
		when(todoServiceMock.retrieveTodos("Youraf"))
		.thenReturn(todos);
		
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Youraf");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void retrieveTodosRelatedToSpring_usingMockWithEmptyList() {
		// create a mock object of todoService
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos=Arrays.asList();
		
		// when call the method retrieve with this parameter return back a todoList
		when(todoServiceMock.retrieveTodos("Youraf"))
		.thenReturn(todos);
		
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Youraf");
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void retrieveTodosRelatedToSpring_usingBDD() {
		// Given : Setup
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos=Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn Angular");
		
		given(todoServiceMock.retrieveTodos("Youraf")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// When : method call
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Youraf");

		// Then : asserts
		// assert that dont accept literal value
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_usingBDD() {
		// Given : Setup
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos=Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn Angular");
		
		given(todoServiceMock.retrieveTodos("Youraf")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// When : method call
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Youraf");

		// Then : asserts
		//verify method will check if some method is called
		// here only LEarn angular didn't contain Spring 
		verify(todoServiceMock).deleteTodo("Learn Angular");
		// or by then(todoServiceMock).should().deleteTodo("Learn Angular");
		
		// verify if a method never called
		verify(todoServiceMock,never()).deleteTodo("Learn Spring MVC");
		// then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		
		// verify if a method is called n times
		verify(todoServiceMock,times(1)).deleteTodo("Learn Angular");
		
		// verify if a method is called at least once
		verify(todoServiceMock,atLeastOnce()).deleteTodo("Learn Angular");
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_capturingArgumentTwice() {
		// declare argument captor
		ArgumentCaptor<String> stringArgumentCaptor=ArgumentCaptor.forClass(String.class);
		
		// define argument captor on specific method call
		
		
		
		// Given : Setup
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos=Arrays.asList("Learn Java", "Learn Spring",
				"Learn Angular");
		
		given(todoServiceMock.retrieveTodos("Youraf")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// When : method call
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Youraf");

		// Then : asserts
		// here  LEarn angular and Learn java will be deleted 
		// capture the arguments of
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2) );
	}


}
