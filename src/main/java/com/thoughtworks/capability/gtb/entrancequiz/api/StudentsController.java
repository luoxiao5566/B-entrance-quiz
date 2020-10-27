package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class StudentsController {
    @Autowired
    GroupService groupService;

    @GetMapping("/students")
    public ResponseEntity getStudents () {
        List<Student> students = groupService.getStudents();
        return ResponseEntity.ok(students);
    }
}