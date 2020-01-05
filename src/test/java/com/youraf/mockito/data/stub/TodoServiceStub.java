package com.youraf.mockito.data.stub;

import java.util.Arrays;
import java.util.List;

import com.youraf.mockito.data.api.TodoService;

public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn Angular");
	}

}
