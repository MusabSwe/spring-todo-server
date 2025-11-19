package com.apps.spring_crud_server.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Todo_list")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
//    Ensures it is not empty or null. (Application level)
    @NotBlank(message = "field is required")
    //Ensures the string is at most 200 characters before saving to DB.
    @Size(max = 200, message = "Todo cannot exceed 200 characters")
    private String todo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
