package io.abhishek.todoapp.repository;

import io.abhishek.todoapp.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    List<CategoryEntity> findCategoryByUserEntityId(Long userId);

    @Query("select t.categoryEntity.id from TodoEntity t where t.id = :todoId")
    Long findCategoryByTodoEntityId(Long todoId);

    @Query("select c from CategoryEntity c inner join TodoEntity t on t.categoryEntity.id = c.id where t.startDate >= :startDate and t.startDate <= :endDate and c.userEntity.id = :userId")
    List<CategoryEntity> getAllTodoByCategoriesForToday(@Param("startDate") ZonedDateTime startDate, @Param("endDate") ZonedDateTime endDate, @Param("userId")Long userId);
}
