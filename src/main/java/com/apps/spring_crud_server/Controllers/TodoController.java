package com.apps.spring_crud_server.Controllers;

import com.apps.spring_crud_server.Models.Todo;
import com.apps.spring_crud_server.Services.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodoList() {
        List<Todo> todos = todoService.getTodoList();
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody() Todo todo) {
        Todo savedTodo = todoService.addTodo(todo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED); // 201
    }

    @PutMapping
    public ResponseEntity<Todo> updateTodo(@Valid @RequestBody() Todo todo) {
        Todo updatedTodo = todoService.updateTodo(todo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK); // 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTodo(@PathVariable Long id) {
        String message = todoService.deleteTodo(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.OK); //200
    }

}