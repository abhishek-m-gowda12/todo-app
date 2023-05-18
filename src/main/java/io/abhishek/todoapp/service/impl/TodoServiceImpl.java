package io.abhishek.todoapp.service.impl;

import io.abhishek.todoapp.dtos.TodoDto;
import io.abhishek.todoapp.exception.ErrorCodes;
import io.abhishek.todoapp.exception.InvalidEntityException;
import io.abhishek.todoapp.repository.TodoRepository;
import io.abhishek.todoapp.service.TodoService;
import io.abhishek.todoapp.validators.TodoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public TodoDto save(TodoDto todoDto) {
    List<String> errors = TodoValidator.validateTodo(todoDto);
        if (!errors.isEmpty()) {
            log.error("Todo is not valid {}", todoDto);
            throw new InvalidEntityException("Todo is not valid", ErrorCodes.TODO_NOT_VALID, errors);
        }
        return TodoDto.fromEntity(todoRepository.save(TodoDto.toEntity(todoDto)));
    }

    @Override
    public List<TodoDto> findAll() {
        return todoRepository.findAll().stream()
                .map(TodoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto findById(Long id) {
        return null;
    }

    @Override
    public List<TodoDto> findByCategory(Long categoryId) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
