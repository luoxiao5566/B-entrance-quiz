package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    private List<Student> students = new ArrayList<>();
    {
        students.add(new Student(1,"成吉思汗"));
        students.add(new Student(2,"鲁班七号"));
        students.add(new Student(2,"太乙真人"));
        students.add(new Student(2,"钟无艳"));
        students.add(new Student(2,"花木兰"));
        students.add(new Student(2,"雅典娜"));
        students.add(new Student(2,"芈月"));
        students.add(new Student(2,"白起"));
        students.add(new Student(2,"刘禅"));
        students.add(new Student(2,"庄周"));
        students.add(new Student(2,"马超"));
        students.add(new Student(2,"刘备"));
        students.add(new Student(2,"哪吒"));
        students.add(new Student(2,"大乔"));
        students.add(new Student(2,"蔡文姬"));
    }


    public List<Student> getStudents() {
        return students;
    }
}
