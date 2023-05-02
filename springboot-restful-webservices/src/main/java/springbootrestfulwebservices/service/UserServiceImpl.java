package springbootrestfulwebservices.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springbootrestfulwebservices.dto.UserDTO;
import springbootrestfulwebservices.entity.User;
import springbootrestfulwebservices.mapper.UserMapper;
import springbootrestfulwebservices.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public UserDTO createUser(UserDTO user) {

//        Convert UserDTO to User
        User newUser = UserMapper.mapToUser(user);
        User savedUser = userRepository.save(newUser);

//        Convert User to UserDTO
        UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);
        return savedUserDTO;
    }

    @Override
    public UserDTO updateUserById(User user) {
        UserDTO updatedUserDTO = getUserById(user.getId());

        if (user.getFirstName()!=null) updatedUserDTO.setFirstName(user.getFirstName());
        if (user.getLastName()!=null) updatedUserDTO.setLastName(user.getLastName());
        if (user.getEmail()!=null) updatedUserDTO.setEmail(user.getEmail());

        System.out.println("Updated user: \n"+updatedUserDTO);

        User updatedUser = userRepository.save(UserMapper.mapToUser(updatedUserDTO));

        return UserMapper.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public UserDTO getUserById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
//        Convert User entity object to UserDTO object
        User user = optionalUser.get();
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepository.findAll();
//        Map each user from User entity to UserDTO and return a list
        return userList.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
    }
}
