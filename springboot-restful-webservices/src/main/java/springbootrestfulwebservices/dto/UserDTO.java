package springbootrestfulwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UserDTO {
    private Long id;
//    User first name should not be null
    @NotNull
    @NotBlank(message = "User first name should not be blank")
    private String firstName;
    //    User last name should not be null
    @NotNull
    @NotBlank(message = "User last name should not be blank")
    private String lastName;
    //    User email should not be null and should be an email
    @NotBlank(message = "User email should not be blank")
    @Email(message = "email should be valid")
    private String email;
}
