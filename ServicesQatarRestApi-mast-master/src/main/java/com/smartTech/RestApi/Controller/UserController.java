package com.smartTech.RestApi.Controller;


import com.smartTech.RestApi.Model.User;

import com.smartTech.RestApi.Repository.UserRepository;

import com.smartTech.RestApi.Service.UserService;
import com.smartTech.RestApi.dto.ApiResponse;
import com.smartTech.RestApi.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1")
public class UserController {



   @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/User")
    public UserResponse<List<User>> getUser() {
        List<User>allUser=userService.getUsers();

        return new UserResponse<>(allUser.size(),allUser);
    }



    @GetMapping("/getSingleUser/{user_id}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long user_id) {
        return new ResponseEntity<> (userService.getSingleUser(user_id), HttpStatus.OK);
    }





    @DeleteMapping("/User")
    public void deleuser(@RequestParam Long user_id) {
        userService.deleteUser(user_id);
    }

    @PostMapping("/User")
    public ResponseEntity<User> SaveUser(@RequestBody User user) {

        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }



    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {

        String response = userService.forgotPassword(email);

        if (!response.startsWith("Invalid")) {
            response = "http://localhost:8080/reset-password?token=" + response;
        }
        return response;
    }

    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam String token,
                                @RequestParam String password) {

        return userService.resetPassword(token, password);
    }

}
