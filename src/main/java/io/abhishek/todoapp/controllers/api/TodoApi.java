package io.abhishek.todoapp.controllers.api;

import io.abhishek.todoapp.dtos.TodoDto;
import io.abhishek.todoapp.handlers.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.abhishek.todoapp.utils.Constants.APP_ROOT;


@Tag(name = "/todos")
public interface TodoApi {

    @PostMapping(value = APP_ROOT + "/todos/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Create To do", summary = "Creates a new to do ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "The newly created To do.")
            })
    ResponseEntity<TodoDto> createTodo(
            @Parameter(name = "Todo DTO", required = true) @RequestBody TodoDto todoDto);

    @PutMapping(value = APP_ROOT + "/todos/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Update Todo", summary = "Updates an existing Todo ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "The newly created Todo.")
            })
    ResponseEntity<TodoDto> updateTodo(
            @Parameter(name = "Todo DTO", required = true) @RequestBody TodoDto user);

    @GetMapping(value = APP_ROOT + "/todos/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Todo Details", summary = "Returns the list of the Todos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of the Todos")
            })
    ResponseEntity<List<TodoDto>> getAllTodos();

    @GetMapping(value = APP_ROOT + "/todos/{todoId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Todo Details", summary = "Returns the Todo by ID", responses = {
            @ApiResponse(responseCode = "200", description = "The Todo"),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = {
                    @Content(schema = @Schema(implementation = ErrorDto.class))})
    })
    ResponseEntity<TodoDto> getTodo(
            @Parameter(name = "todoId", description = "The Todo id", required = true) @PathParam(value = "todoId") Long todoId
    );

    @DeleteMapping(value = APP_ROOT + "/todos/delete/{id:.+}")
    @Operation(description = "Delete Todo", summary = "Deletes a Todo by ID", responses = {
            @ApiResponse(responseCode = "200", description = "The Todo deleted"),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = {
                    @Content(schema = @Schema(implementation = ErrorDto.class))})
    })
    ResponseEntity<Void> deleteTodo(
            @Parameter(name = "id", description = "The Todo id", required = true) Long id
    );
}
