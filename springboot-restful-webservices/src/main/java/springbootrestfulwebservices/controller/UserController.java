package springbootrestfulwebservices.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestfulwebservices.dto.UserDTO;
import springbootrestfulwebservices.service.UserService;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Delete User, Get User, Get All Users"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

//    Get all users from the database
    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get all users from the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }
    @Operation(
            summary = "Get User By Id REST API",
            description = "Get User By Id REST API is used to get a user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
    //Get a user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserById(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save a user in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )
//    Create a new user
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user){
        UserDTO newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
//    Update a user by id
    @PutMapping("/{id}/update")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long id,
            @RequestBody @Valid UserDTO user){
        user.setId(id);
        UserDTO updatedUser = userService.updateUserById(user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
//    Delete user by id
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted Successfully!");
    }
}
