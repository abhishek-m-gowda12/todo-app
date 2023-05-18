package io.abhishek.todoapp.entities;

import io.abhishek.todoapp.entities.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


/**
 * @author abhishek-m-gowda12
 */

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role", schema = "application")
@NoArgsConstructor
public class RoleEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserEntity.class, optional = false)
    @JoinColumn(name = "userEntity_id", nullable = false)
    private UserEntity userEntity;
}
