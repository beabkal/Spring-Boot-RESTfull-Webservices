package springbootrestfulwebservices.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootrestfulwebservices.dto.UserDTO;
import springbootrestfulwebservices.entity.User;
import springbootrestfulwebservices.exception.EmailAlreadyExistsException;
import springbootrestfulwebservices.exception.ResourceNotFoundException;
import springbootrestfulwebservices.mapper.AutoUserMapper;
import springbootrestfulwebservices.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO user) {

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
//        Check if email already exists and throw a custom exception
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already exists for a user");
        }
//        Convert UserDTO to User
        User newUser = modelMapper.map(user, User.class);
//        String newUserEmail = newUser.getEmail();
        User savedUser = userRepository.save(newUser);
//        Convert User to UserDTO
        UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);
        return savedUserDTO;
    }

    @Override
    public UserDTO updateUserById(User user) {
        UserDTO updatedUserDTO = getUserById(user.getId());

        if (user.getFirstName() != null) updatedUserDTO.setFirstName(user.getFirstName());
        if (user.getLastName() != null) updatedUserDTO.setLastName(user.getLastName());
        if (user.getEmail() != null) updatedUserDTO.setEmail(user.getEmail());

        System.out.println("Updated user: \n" + updatedUserDTO);

        User updatedUser = userRepository.save(AutoUserMapper.MAPPER.mapToUser(updatedUserDTO));

        return AutoUserMapper.MAPPER.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        if (getUserById(id) != null)
        userRepository.deleteById(id);
    }


    @Override
    public UserDTO getUserById(Long id) {
        String idStr = Long.toString(id);
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", idStr));

//        Convert User entity object to UserDTO object
//        User user = optionalUser.get();
        return AutoUserMapper.MAPPER.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
//        Map each user from User entity to UserDTO using a model mapper and return a list
        return userList.stream().map((user)-> AutoUserMapper.MAPPER.mapToUserDTO(user)).collect(Collectors.toList());
    }
}
