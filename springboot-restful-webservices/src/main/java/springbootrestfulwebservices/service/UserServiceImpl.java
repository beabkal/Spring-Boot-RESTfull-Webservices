package springbootrestfulwebservices.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springbootrestfulwebservices.entity.User;
import springbootrestfulwebservices.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUserById(User user) {
        User updatedUser = getUserById(user.getId());

        if (user.getFirstName()!=null) updatedUser.setFirstName(user.getFirstName());
        if (user.getLastName()!=null) updatedUser.setLastName(user.getLastName());
        if (user.getEmail()!=null) updatedUser.setEmail(user.getEmail());

        System.out.println("Updated user: \n"+updatedUser);
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
