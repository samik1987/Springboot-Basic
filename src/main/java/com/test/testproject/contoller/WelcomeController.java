package com.test.testproject.contoller;

import com.test.testproject.dto.StudentDto;
import com.test.testproject.models.Student;
import com.test.testproject.services.StdudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

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

        logger.info("Looging from Samik's application");
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

    @GetMapping("/passnfail/{stdId}")
    public StudentDto GetStudentForPassNFail(@PathVariable int stdId)
    {
        ///System.out.print("Samik");
        return  _stdudentService.GetStudentForPassNFail(stdId);
    }



    @GetMapping("/studentbyid/{id}")
    public Student getStudetById(@PathVariable int id ,@RequestParam(defaultValue = "Testname") String name)
    {

        System.out.println("Student name =" + name);
        return  _stdudentService.GetStudentById(id);
    }

    @GetMapping("/studentbyname/{name}")
    public Student getStudetByname(@PathVariable String name)
    {
        return  _stdudentService.GetStudentByName(name);
    }

    @GetMapping("/stdbynamecontain/{name}")
    public Student getStudetBynameContain(@PathVariable String name)
    {
        return  _stdudentService.GetStudentByNameContain(name);
    }

    @GetMapping("/deletestudent/{id}")
    public List<Student> getStudetBynameContain(@PathVariable int id)
    {
        return  _stdudentService.deleteById(id);
    }



    @PostMapping("/addStudent")
    public List<Student> addStudent(@RequestBody Student std)
    {
        ///System.out.print("Samik");
        return  _stdudentService.AddStudent(std);
    }

    @PostMapping("/addAllStudent")
    public List<Student> addAllStudent(@RequestBody List<Student> studentList)
    {
        ///System.out.print("Samik");
        return  _stdudentService.AddAllStudent(studentList);
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
