package com.app.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Todo;
import com.app.service.TodoService;

@Controller
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listTodos(ModelMap model) {
		model.put("todos", todoService.listAllTodos());
		return "list-todos";
	}

	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodoById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap model) {
		Todo todo = new Todo(111, "Arun", "", LocalDate.now(), false);
		model.put("todo", todo);
		return "add-todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addTodo(Todo todo) {
		todoService.addTodo(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id) {
		Todo todo = todoService.findTodoByid(id);
		model.put("todo",todo);
		return "add-todo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(Todo todo) {
		todoService.UpdateTodo(todo);
		return "redirect:list-todos";
	}

}
