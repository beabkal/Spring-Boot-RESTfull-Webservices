package springbootrestfulwebservices.service;

import springbootrestfulwebservices.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO user);
    UserDTO updateUserById(UserDTO user);

    void deleteUserById(Long id);

}
