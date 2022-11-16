package htl.steyr.spring_tests.controller;

import htl.steyr.spring_tests.models.Student;
import htl.steyr.spring_tests.models.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/list")
    public List<Student> listAll() {
        return repository.findAll();
    }
}
