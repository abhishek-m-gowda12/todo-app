package io.abhishek.todoapp.dtos;

import io.abhishek.todoapp.entities.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {

    private Long id;

    private String title;

    private String description;

    private ZonedDateTime startDate;

    private boolean done;

    private boolean favorite;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CategoryDto category;

    public static TodoEntity toEntity(TodoDto todoDto) {
        final TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(todoDto.getId());
        todoEntity.setTitle(todoDto.getTitle());
        todoEntity.setDescription(todoDto.getDescription());
        todoEntity.setDone(todoDto.isDone());
        todoEntity.setFavorite(todoDto.isFavorite());
        todoEntity.setStartDate(ZonedDateTime.now());
        todoEntity.setCategoryEntity(CategoryDto.toEntity(todoDto.getCategory()));

        return todoEntity;
    }

    public static TodoDto fromEntity(TodoEntity todoEntity) {
        return TodoDto.builder()
                .id(todoEntity.getId())
                .title(todoEntity.getTitle())
                .description(todoEntity.getDescription())
                .startDate(todoEntity.getStartDate())
                .done(todoEntity.isDone())
                .favorite(todoEntity.isFavorite())
                .build();
    }
}
