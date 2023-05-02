package springbootrestfulwebservices.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestfulwebservices.dto.UserDTO;
import springbootrestfulwebservices.entity.User;
import springbootrestfulwebservices.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

//    Get all users from the database
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }
    //Get a user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserById(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
//    Create a new user
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        UserDTO newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

//    Update a user by id
    @PutMapping("/{id}/update")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long id,
            @RequestBody User user){
        user.setId(id);
        UserDTO updatedUser = userService.updateUserById(user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

//    Delete user by id
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted Successfully!");
    }
}
