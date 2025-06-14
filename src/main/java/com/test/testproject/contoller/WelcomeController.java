package com.test.testproject.contoller;

import com.test.testproject.dto.StudentDto;
import com.test.testproject.models.Student;
import com.test.testproject.services.StdudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hr-api/v1")
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

    @GetMapping("/allstudent")
    public List<Student> getAllStdent()
    {
        ///System.out.print("Samik");
        return  _stdudentService.GetAllStudent();
    }

    @GetMapping("/allstudentbygroup")
    public Map<String, Long> getAllStdentsByNumberGrouping()
    {
        ///System.out.print("Samik");
        return  _stdudentService.GetAllStudentByGrouping();
    }

    @GetMapping("/studentbyid/{id}")
    public Student getStudetById(@PathVariable int id ,@RequestParam String name)
    {

        System.out.println("Student name =" + name);
        return  _stdudentService.GetStudentById(id);
    }



    @PostMapping("/addStudent")
    public List<Student> addStudent(@RequestBody Student std)
    {
        ///System.out.print("Samik");
        return  _stdudentService.AddStudent(std);
    }

    @PutMapping("/updatestudent/{stdId}")
    public ResponseEntity<?> updateStudent(@RequestBody Student updatedStd,@PathVariable int stdId) throws Exception {

         try {
             System.out.print(".....updatestudent.....");
             return new ResponseEntity<>(_stdudentService.UpdatedStudent(updatedStd), HttpStatus.OK) ;
         }
         catch (Exception ex)
         {
             return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
             //throw  new Exception("Data Not present");
         }
    }



}
