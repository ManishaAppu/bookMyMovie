package com.assessment.Repository;

import com.assessment.Entity.User;
import com.assessment.Entity.UserCredentials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface UserCredentialsRepository extends CrudRepository<UserCredentials, Integer> {

//    public static final String FIND_USERNAME = "SELECT COUNT(USER_CREDENTIALS_ID) FROM USER_CREDENTIALS WHERE USERNAME= ?";

//    @Query(value = FIND_USERNAME, nativeQuery = true)
    public UserCredentials findByUsername(String username);

    public static final String CHECK_NAME_AND_PASSWORD = "SELECT * FROM USER_CREDENTIALS WHERE USERNAME = ?";

    @Query(value = CHECK_NAME_AND_PASSWORD, nativeQuery = true)
    public UserCredentials checkUser(String username);

}
