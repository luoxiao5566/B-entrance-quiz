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

    Map<String,List<Student>> groups = new HashMap<>();
    {
        groups.put("第一组",new ArrayList<>());
        groups.put("第二组",new ArrayList<>());
        groups.put("第三组",new ArrayList<>());
        groups.put("第四组",new ArrayList<>());
        groups.put("第五组",new ArrayList<>());
        groups.put("第六组",new ArrayList<>());
    }

    Map<Integer,String> groupNameMapping = new HashMap<>();
    {
        groupNameMapping.put(1,"第一组");
        groupNameMapping.put(2,"第二组");
        groupNameMapping.put(3,"第三组");
        groupNameMapping.put(4,"第四组");
        groupNameMapping.put(5,"第五组");
        groupNameMapping.put(6,"第六组");

    }

    public void createStudent(String studentName) {
        int index = students.size()+1;
        Student student = new Student(index,studentName);
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }


    public Map<String, List<Student>> getGroups() {
        List<Student> tempStudents = new ArrayList<>();
        for (Student student: students) {
            tempStudents.add(student);
        }
        Collections.shuffle(tempStudents);
        if (groups.get(groupNameMapping.get(1)).size() != 0){
            for (int i = 1; i < 7; i++) {
                groups.get(groupNameMapping.get(i)).clear();
            }
        }
        int index = 0;
        int groupId = 1;
        while (index < tempStudents.size()){
            if (groupId == 7){
                groupId = 1;
            }
            String groupsName = groupNameMapping.get(groupId);
            groups.get(groupsName).add(tempStudents.get(index));
            groupId++;
            index++;
        }
        return groups;
    }

}
