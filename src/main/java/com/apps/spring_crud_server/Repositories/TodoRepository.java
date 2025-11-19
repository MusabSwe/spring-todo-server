package com.apps.spring_crud_server.Repositories;

import com.apps.spring_crud_server.Models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}