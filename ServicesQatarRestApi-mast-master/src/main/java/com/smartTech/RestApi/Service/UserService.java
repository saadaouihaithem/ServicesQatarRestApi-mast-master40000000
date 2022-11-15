package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Services;
import com.smartTech.RestApi.Model.User;

import java.util.List;

public interface UserService {

    User getSingleUser(Long user_id );
    List<User> getUsers();
    User saveUser(User user);

    void deleteUser(Long user_id );

    String forgotPassword(String email);
    String resetPassword(String token, String password);
}
