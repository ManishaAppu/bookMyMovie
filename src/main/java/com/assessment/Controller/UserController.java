package com.assessment.Controller;

import com.assessment.Entity.User;
import com.assessment.Model.UserModel;
import com.assessment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUsers/{id}")
    public User getUsers(@PathVariable int id){
      return userService.getUsersById(id);
    }

    @PostMapping("/newUser")
    public String registerNewUser(@RequestBody UserModel userModel){
        return "Successfully added the User... \n User Id " + userService.addNewUser(userModel);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserModel userModel){
        return " Successfully Logged In \n User Id " + userService.userLogin(userModel);
    }
}
