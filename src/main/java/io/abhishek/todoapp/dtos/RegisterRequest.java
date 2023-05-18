package io.abhishek.todoapp.dtos;

import io.abhishek.todoapp.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder
@AllArgsConstructor
public class RegisterRequest {

  @NonNull
  private String firstname;
  @NonNull
  private String lastname;
  @NonNull
  private String email;
  @NonNull
  private String password;
  @NonNull
  private Role role;
}
