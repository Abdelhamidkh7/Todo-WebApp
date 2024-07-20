package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;
    

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }


    @RequestMapping("list-todos")
    public String ListAllTodos(ModelMap model){
        List<Todo>  todos = todoService.findbyUsername("Abed");
        model.put("Todo", todos);
        return "listTodos";
    }

    @RequestMapping(value ="add-todo",method=RequestMethod.GET)
    public String showTodoPage(ModelMap model){
        Todo todo = new Todo(0, (String)model.get("name"), "", LocalDate.now().plusYears(1), false);
        model.put("todo",todo);
        //List<Todo>  todos = todoService.findbyUsername("Abed");
        
        return "todo";
    }

    @RequestMapping(value ="add-todo",method=RequestMethod.POST)
    public String saveTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }
        todoService.addTodo((String)model.get("name"), todo.getDescription(), todo.getTargetDate(), false);
        
        //List<Todo>  todos = todoService.findbyUsername("Abed");
        
        return "redirect:list-todos";
    }
    @RequestMapping("delete-todo")
    public String DelteAllTodos(@RequestParam int id){
        todoService.deleteTodo(id);
       
        return "redirect:list-todos";
    }
    @RequestMapping(value= "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        
        //todoService.updateTodo(id);
       
        return "todo";
    }
    @RequestMapping(value= "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result){
if(result.hasErrors()){
    return "todo";
}
String username = (String)model.get("name");
todo.setUsername(username);

       
       todoService.updateTodo(todo);
     


        
        //todoService.updateTodo(id);
       
        return "redirect:list-todos";
    }


    
}
