package com.lcwd.controller;


import com.lcwd.entity.User;
import com.lcwd.payload.ApiResponse;
import com.lcwd.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    //get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    //get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        ApiResponse apiResponse = ApiResponse.builder()
                .message("User deleted successfully").success(true).status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(apiResponse);
    }

    //update user
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user){
        User updatedUser = userService.updateUser(userId,user);
        return ResponseEntity.ok(updatedUser);
    }
}
