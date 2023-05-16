package io.abhishek.todoapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author abhishek-m-gowda12
 */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
    private Long aa;
    private String bb;
}
