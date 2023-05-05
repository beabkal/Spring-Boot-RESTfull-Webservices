package springbootrestfulwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User DTO model"
)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UserDTO {
    private Long id;
//    User first name should not be null
    @Schema(
            description = "user first name"
    )
    @NotNull
    @NotBlank(message = "User first name should not be blank")
    private String firstName;
    //    User last name should not be null
    @Schema(
            description = "user last name"
    )
    @NotNull
    @NotBlank(message = "User last name should not be blank")
    private String lastName;
    //    User email should not be null and should be an email
    @Schema(
            description = "user email address"
    )
    @NotBlank(message = "User email should not be blank")
    @Email(message = "email should be valid")
    private String email;
}
