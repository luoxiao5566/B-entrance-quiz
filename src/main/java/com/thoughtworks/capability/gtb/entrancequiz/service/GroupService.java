package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {
    // TODO GTB-知识点: - 应该使用Repository层保存数据
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

    // TODO GTB-工程实践: - 代码不优雅
    // TODO GTB-完成度: - 应该在点击分组的时候才生成组
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
        // TODO GTB-工程实践: - 计算id的方式不够健壮，可以使用字段保存最大id
        int index = students.size()+1;
        Student student = new Student(index,studentName);
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    // TODO GTB-工程实践: - 长方法，建议抽子方法来提高可读性
    public void grouping() {
        List<Student> tempStudents = new ArrayList<>();
        for (Student student: students) {
            tempStudents.add(student);
        }
        Collections.shuffle(tempStudents);
        if (groups.get(1).size() != 0){
            // TODO GTB-工程实践: - Magic Number
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
