package io.abhishek.todoapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "category")
public class CategoryEntity  extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "userEntityId")
    @JsonIgnore
    private UserEntity userEntity;

    @OneToMany(mappedBy = "categoryEntity", fetch = FetchType.EAGER)
    private List<TodoEntity> todoEntityList;
}
