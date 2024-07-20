package com.myspringproject.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>() ;
        private static int todosCount = 0;
    
    static {
        todos.add(new Todo(++todosCount,"Abdelhamid","Learn AWS 1", 
        LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"Abdelhamid","Learn DevOps 1", 
        LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"Abdelhamid","Learn Full Stack 1", 
        LocalDate.now().plusYears(3),false));
    }
     List<Todo> findbyUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        
        return todos.stream().filter(predicate).toList();
    }
    public void addTodo(String username,String description,LocalDate targetDate , boolean done){
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);

    }
    public void deleteTodo(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
    public Todo findById(int id) {
        // TODO Auto-generated method stub
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public void updateTodo(@Valid Todo todo){
        deleteTodo(todo.getId());
        // todo.setDescription(desc);
        todos.add(todo);

    }
    
}
