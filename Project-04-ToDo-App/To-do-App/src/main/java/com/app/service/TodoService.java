package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.app.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 110;

	static {
		todos.add(new Todo(++todosCount, "Arun", "Learn AWS", LocalDate.now(), false));
		todos.add(new Todo(++todosCount, "Arun", "Learn Azure", LocalDate.now(), false));
		todos.add(new Todo(++todosCount, "Arun", "Learn excel", LocalDate.now(), false));
		todos.add(new Todo(++todosCount, "Arun", "Learn java", LocalDate.now(), false));
	}

	public List<Todo> listAllTodos() {
		return todos;
	}

	public void deleteTodoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		todosCount--;

	}

	public void addTodo(Todo todo) {
		todos.add(new Todo(++todosCount, todo.getUserName(), todo.getDescription(), todo.getTargetDate(),
				todo.isStatus()));

	}

	public Todo findTodoByid(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void UpdateTodo(Todo todo) {
		deleteTodoById(todo.getId());
		todos.add(todo);
	}

}
