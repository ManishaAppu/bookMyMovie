package com.assessment.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class UserModel {

    private String firstName;

    private String lastName;

    private String location;

    private String phoneNumber;

    private String username;

    private String password;
}
