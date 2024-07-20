package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;


@Controller
public class SayHelloController {

    //"say-Hello" => "Hello! What are you learning today?"
    // http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";

    }


    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first HTML PAGE </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page body");
        sb.append("</body>");
        sb.append("</html>");


        return sb.toString();

    }
    //sayHellp.jsp
    //src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    //src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    //src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    @RequestMapping("say-hello-jsp")
    // @ResponseBody
    public String sayHelloJSP() {
        return "sayHello";

    }

    
    
    
    
    




  

    
}
