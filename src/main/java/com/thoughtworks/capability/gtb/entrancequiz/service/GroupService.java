package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {
    private List<Student> students = new ArrayList<>();
    {
        students.add(new Student(1,"成吉思汗"));
        students.add(new Student(2,"鲁班七号"));
        students.add(new Student(3,"太乙真人"));
        students.add(new Student(4,"钟无艳"));
        students.add(new Student(5,"花木兰"));
        students.add(new Student(6,"雅典娜"));
        students.add(new Student(7,"芈月"));
        students.add(new Student(8,"白起"));
        students.add(new Student(9,"刘禅"));
        students.add(new Student(10,"庄周"));
        students.add(new Student(11,"马超"));
        students.add(new Student(12,"刘备"));
        students.add(new Student(13,"哪吒"));
        students.add(new Student(14,"大乔"));
        students.add(new Student(15,"蔡文姬"));
    }

    Map<Integer,List<Student>> groups = new HashMap<>();
    {
        groups.put(1,new ArrayList<>());
        groups.put(2,new ArrayList<>());
        groups.put(3,new ArrayList<>());
        groups.put(4,new ArrayList<>());
        groups.put(5,new ArrayList<>());
        groups.put(6,new ArrayList<>());
    }


    public void createStudent(String studentName) {
        int index = students.size()+1;
        Student student = new Student(index,studentName);
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }


    public void grouping() {
        List<Student> tempStudents = new ArrayList<>();
        for (Student student: students) {
            tempStudents.add(student);
        }
        Collections.shuffle(tempStudents);
        if (groups.get(1).size() != 0){
            for (int i = 1; i < 7; i++) {
                groups.get(i).clear();
            }
        }
        int index = 0;
        int groupId = 1;
        while (index < tempStudents.size()){
            if (groupId == 7){
                groupId = 1;
            }
            groups.get(groupId).add(tempStudents.get(index));
            groupId++;
            index++;
        }
    }


    public Map<Integer, List<Student>> getGroups() {
        return groups;
    }
}
