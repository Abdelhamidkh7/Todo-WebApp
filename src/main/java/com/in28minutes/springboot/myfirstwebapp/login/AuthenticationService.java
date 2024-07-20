package com.in28minutes.springboot.myfirstwebapp.login;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password){

        boolean isValidUserName = username.equalsIgnoreCase("Abdelhamid");
        boolean isValidPassword = password.equalsIgnoreCase("abed");

        return isValidUserName  && isValidPassword;
    }
    
}
