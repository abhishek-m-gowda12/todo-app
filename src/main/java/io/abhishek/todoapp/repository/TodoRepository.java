package io.abhishek.todoapp.repository;

import io.abhishek.todoapp.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findTodoEntityByCategoryEntityId(Long categoryId);
}
