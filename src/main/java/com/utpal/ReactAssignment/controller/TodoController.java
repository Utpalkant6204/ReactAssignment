package com.utpal.ReactAssignment.controller;

import com.utpal.ReactAssignment.Entity.Todos;
import com.utpal.ReactAssignment.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("https://todo-spring-boot-frontend.vercel.app/")
public class TodoController {


    @Autowired
   private TodoService todoService;

    @PostMapping("/saveTodo")
    public Todos saveTodos(@RequestBody Todos todos){
        return todoService.saveTodos(todos);
    }

    @GetMapping("/getTodos")
    public List<Todos> getTodos(){
        return todoService.getTodos();
    }

    @GetMapping("/getTodo/{id}")
    public ResponseEntity<Object> fetchbyId(@PathVariable("id") Long Id){
        Todos todo = todoService.getTodobyId(Id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data available");
        }
    }

    @PutMapping("/updateTodo/{id}")
    public Todos updatebyId(@PathVariable("id") Long Id, @RequestBody Todos todo){
        return todoService.updatebyId(Id, todo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public boolean deletebyId(@PathVariable("id") Long id){
        boolean ap = todoService.deletebyId(id);
        return ap;
    }
}
