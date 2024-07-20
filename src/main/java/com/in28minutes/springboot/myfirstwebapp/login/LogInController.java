package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LogInController {
    private AuthenticationService authenticationService ;
    // = new AuthenticationService()
    //Model
   public LogInController(AuthenticationService authenticationService){
    super();
    this.authenticationService =authenticationService;


    }
    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login(){
       
 
        return "Login";
    }
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name , @RequestParam String password, ModelMap map){
        if(authenticationService.authenticate(name, password)){
            map.put("name",name);

       //Authentication
       //name - Abdelhamid
       //password - abed
 
        return "welcome";

        }
        map.put("error","Wrong UserName or Password");
        return "Login";
       
    }
    
}
