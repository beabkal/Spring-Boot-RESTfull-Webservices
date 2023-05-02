package springbootrestfulwebservices.mapper;

import springbootrestfulwebservices.dto.UserDTO;
import springbootrestfulwebservices.entity.User;

public class UserMapper {

//    Convert UserDTO to User Entity object
    public static User mapToUser(UserDTO userDTO){
        User user = new User(userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail());

        return user;
    }
//    Convert a User entity to a UserDTO
    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

        return userDTO;
    }
}
