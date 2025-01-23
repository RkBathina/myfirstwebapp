package com.prep.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	//we need static block to intialize static variables
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount=0;
	
	static {
		todos.add(new Todo(++todosCount, "kittuTutor", "Get AWS Certified", 
							LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "kittuTutor", "Learn DevOps", 
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "kittuTutor", "Learn FullStack", 
				LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate
		=todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
		
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deletById(int id) {
		Predicate<? super Todo> predicate
				=todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate
		=todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deletById(todo.getId());
		todos.add(todo);
	}


}
