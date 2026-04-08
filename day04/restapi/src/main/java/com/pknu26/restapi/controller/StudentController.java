package com.pknu26.restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pknu26.restapi.entity.Student;

@RestController
public class StudentController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API!";
    }

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("신영", 28);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        // 수정 불가능
        return List.of(
            new Student("성규", 36),
            new Student("우현", 34),
            new Student("명수", 32)
        );
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        return "User ID: " + id;
    }
}
