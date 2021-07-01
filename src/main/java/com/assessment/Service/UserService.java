package com.assessment.Service;

import com.assessment.Entity.User;
import com.assessment.Entity.UserCredentials;
import com.assessment.Model.UserModel;
import com.assessment.Repository.UserCredentialsRepository;
import com.assessment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(){

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUsersById(int id){
        return userRepository.findById(id).get();
    }

    public int addNewUser(UserModel userModel) throws RuntimeException{
        System.out.println(" Inside of the userModel");
        String encodedPassword = encodePassword(userModel.getPassword());
        UserCredentials usernameExist = userCredentialsRepository.findByUsername(userModel.getUsername());
         if (usernameExist != null){
             throw new RuntimeException("Username Already Exists... Please try again with someother");
         }
       int userId = userRepository.save(new User(userModel.getFirstName(),userModel.getLastName(), userModel.getLocation(), userModel.getPhoneNumber())).getUsedId();
       return userCredentialsRepository.save(new UserCredentials(userId,userModel.getUsername(),encodedPassword)).getUser_credentials_id();
    }

    public int userLogin(UserModel userModel){
        String encodedPassword = encodePassword(userModel.getPassword());
        UserCredentials output = userCredentialsRepository.checkUser(userModel.getUsername());

        if(output != null && output.getPassword() != null){
            System.out.println(" Value in output[1] " +  output.getPassword());
            Boolean isPasswordMatch = bCryptPasswordEncoder.matches(userModel.getPassword(),  output.getPassword());
            return output.getUser_id();
        }
        else{
            throw new RuntimeException("User Not Exist");
        }

       /* if(userId == 0){
            throw new RuntimeException("User Not Exist");
        }*/

    }

    public String encodePassword(String password){
          return bCryptPasswordEncoder.encode(password);
    }



}
