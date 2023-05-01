package springbootrestfulwebservices.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }
    //Get a user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
//    Create a new user
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = new User();

        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());

        userService.createUser(newUser);
        System.out.println("Created user\n" + newUser.toString());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

//    Update a user by id
    @PutMapping("/{id}/update")
    public ResponseEntity<User> updateUserById(@PathVariable Long id,
            @RequestBody User user){
        user.setId(id);
        User updatedUser = userService.updateUserById(user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

//    Delete user by id
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted Successfully!");
    }
}
