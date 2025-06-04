package com.test.testproject.contoller;

import com.test.testproject.models.Student;
import com.test.testproject.services.StdudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WelcomeController {

    @Autowired
    private StdudentService _stdudentService;

    // http://localhost:8081/hello
    @GetMapping("/hello")
    public String helloPage(Model model) {

        model.addAttribute("message", "Hello from JSP!");
        return "hello"; // resolved to /WEB-INF/views/hello.jsp
    }

    @GetMapping("/welcome")
    public String Welcome()
    {
        System.out.print("Samik");
        return  "Welcome to My World...";
    }

    @GetMapping("/allstdent")
    public List<Student> getAllStdenta()
    {
        ///System.out.print("Samik");
        return  _stdudentService.GetAllStudent();
    }

    @GetMapping("/studentbyid/{id}")
    public Student getStudetById(@PathVariable int id)
    {
        ///System.out.print("Samik");
        return  _stdudentService.GetStudentById(id);
    }
}
