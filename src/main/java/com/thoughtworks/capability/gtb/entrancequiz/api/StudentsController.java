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
    // TODO GTB-知识点: - 推荐使用构造器注入
    @Autowired
    GroupService groupService;

    @GetMapping("/students")
    // TODO GTB-知识点: - 没有使用泛型
    // TODO GTB-工程实践: - 注意代码风格，方法名和小括号中间不加空格
    public ResponseEntity getStudents () {
        List<Student> students = groupService.getStudents();
        return ResponseEntity.ok(students);
    }

    // TODO GTB-知识点: - 违反Restful实践, url不合理
    @PostMapping("/addStudent")
    public ResponseEntity addStudent (@RequestBody String studentName) {
        groupService.createStudent(studentName);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/groups")
    // TODO GTB-完成度: - 返回的分组缺少组名
    public ResponseEntity getGroups () {
        // TODO GTB-工程实践: - 应该创建专门的对象来表示Group
        Map<Integer,List<Student>> groups = groupService.getGroups();
        return ResponseEntity.ok(groups);
    }

    @PostMapping("/groups")
    // TODO GTB-知识点: - 违反Restful实践, Post请求成功后应该返回201
    // TODO GTB-工程实践: - 方法名不合理
    public ResponseEntity addStudent () {
        groupService.grouping();
        Map<Integer,List<Student>> groups = groupService.getGroups();
        return ResponseEntity.ok(groups);
    }
}
