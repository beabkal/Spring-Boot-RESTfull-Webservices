package springbootrestfulwebservices.service;

import springbootrestfulwebservices.dto.UserDTO;
import springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO user);
    UserDTO updateUserById(User user);

    void deleteUserById(Long id);

}
