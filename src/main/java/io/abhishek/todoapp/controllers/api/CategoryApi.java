package io.abhishek.todoapp.controllers.api;

import io.abhishek.todoapp.dtos.CategoryDto;
import io.abhishek.todoapp.dtos.TodoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.abhishek.todoapp.utils.Constants.APP_ROOT;

@Tag(name = "/categories")
@RequestMapping(value = APP_ROOT)
public interface CategoryApi {

    @PostMapping(value = "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Create category", summary = "Creates a new category ", responses = {
            @ApiResponse(responseCode = "201", description = "The newly created Category.")
    })
    ResponseEntity<CategoryDto> createCategory(
            @Parameter(name = "Category DTO", required = true) @RequestBody CategoryDto categoryDto);

    @PutMapping(value = "/categories/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Update Category", summary = "Updates an existing Category ", responses = {
            @ApiResponse(responseCode = "201", description = "The newly created user.")
    })
    ResponseEntity<CategoryDto> updateCategory(
            @Parameter(name = "Category DTO", required = true) @RequestBody CategoryDto user);

    @GetMapping(value = "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Category Details", summary = "Returns the list of the categories", responses = {
            @ApiResponse(responseCode = "200", description = "List of the categories"),
    })
    ResponseEntity<List<CategoryDto>> getAllCategories();

    @GetMapping(value = "/categories/todos/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Todo Details by category ID", summary = "Returns the list of the Todo of a selected category", responses = {
            @ApiResponse(responseCode = "200", description = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(
            @Parameter(name = "id", description = "Category ID", required = true) @PathVariable("id") Long id
    );

    @GetMapping(value = "/categories/todos/today/{userId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "List of all categories and Todo for today", summary = "Returns the list of the Todo of a selected category", responses = {
            @ApiResponse(responseCode = "200", description = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(
            @Parameter(name = "userId", description = "User ID", required = true) @PathVariable("userId") Long userId
    );

    @GetMapping(value = "/categories/users/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Category Details by user ID", summary = "Returns the list of the categories of a selected user", responses = {
            @ApiResponse(responseCode = "200", description = "List of the categories"),
    })
    ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(
            @Parameter(name = "id", description = "User ID", required = true) @PathVariable(value = "id") Long id
    );

    @GetMapping(value = "/categories/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Category", summary = "Returns Category By ID", responses = {
            @ApiResponse(responseCode = "200", description = "The Category"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<CategoryDto> getCategory(
            @Parameter(name = "id", description = "The category id", required = true) @PathParam(value = "id") Long id
    );

    @DeleteMapping(value = "/categories/delete/{id:.+}")
    @Operation(description = "Delete category", summary = "Deletes a category by ID", responses = {
            @ApiResponse(responseCode = "200", description = "The category deleted"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<Void> deleteCategory(
            @Parameter(name = "id", description = "The category id", required = true) @PathVariable(value = "id") Long id
    );
}
