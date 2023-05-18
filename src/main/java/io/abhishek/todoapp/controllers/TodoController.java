package io.abhishek.todoapp.controllers;

import io.abhishek.todoapp.controllers.api.TodoApi;
import io.abhishek.todoapp.dtos.TodoDto;
import io.abhishek.todoapp.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.abhishek.todoapp.utils.Constants.APP_ROOT;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class TodoController implements TodoApi {

    private final TodoService todoService;

    //    @PostMapping(value = APP_ROOT + "/todos/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoDto> createTodo(TodoDto userDto) {
        return new ResponseEntity<>(todoService.save(userDto), HttpStatus.CREATED);
    }

    public ResponseEntity<TodoDto> updateTodo(TodoDto todoDto) {
        return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
    }

    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<TodoDto> getTodo(Long todoId) {
        return new ResponseEntity<>(todoService.findById(todoId), HttpStatus.OK);
    }

    public ResponseEntity deleteTodo(Long id) {
        return null;
    }
}
