package springbootrestfulwebservices.service;

import springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUserById(User user);

    void deleteUserById(Long id);

}
