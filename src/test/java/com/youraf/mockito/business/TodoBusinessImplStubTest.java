package com.youraf.mockito.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.youraf.mockito.data.api.TodoService;
import com.youraf.mockito.data.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Youraf");
		// 2 because two todos has spring
		assertEquals(2, todos.size());
	}

}
