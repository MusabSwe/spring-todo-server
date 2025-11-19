package com.apps.spring_crud_server.Services;

import com.apps.spring_crud_server.Models.Todo;
import com.apps.spring_crud_server.Repositories.TodoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private static final Logger logger = LoggerFactory.getLogger(TodoService.class);

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo) {
        logger.info("Adding new todo: {}", todo.getTodo());
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getId()).orElseThrow(() -> new RuntimeException("Todo not found with id: " + todo.getId()));
        existingTodo.setTodo(todo.getTodo());
        logger.info("todo updated: id={}, todo={} ", existingTodo.getId(), existingTodo.getTodo());
        return todoRepository.save(existingTodo);
    }

    public String deleteTodo(Long id) {
        Todo existingTodo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
        todoRepository.delete(existingTodo);
        logger.info("todo removed: id={}, todo={} ", existingTodo.getId(), existingTodo.getTodo());
        return "Todo id " + id + " and with content '" + existingTodo.getTodo() + "' was removed successfully";
    }
}
