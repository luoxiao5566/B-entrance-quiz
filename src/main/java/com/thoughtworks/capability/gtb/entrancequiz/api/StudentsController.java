package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/addStudent")
    public ResponseEntity addStudent (@RequestBody String studentName) {
        groupService.createStudent(studentName);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/groups")
    public ResponseEntity getGroups () {
        Map<String,List<Student>> students = groupService.getGroups();
        return ResponseEntity.ok(students);
    }
}
