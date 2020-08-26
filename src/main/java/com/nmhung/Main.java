package com.nmhung;

import com.nmhung.model.Student;
import com.nmhung.model.TestKeyGroup;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<String> ls = new ArrayList<String>();
//
//        Student student = new Student();
//        student.setId("001");
//
//        Set<Student> students = new HashSet<>();
//        students.add(student);
//
//        Student student1 = new Student(){{
//            setId("001");
//        }};
//
//        System.out.println(student.getClass().getSimpleName());
//
//
//        System.out.println(students.contains(student1));


        TestKeyGroup a = new TestKeyGroup("name",1);
        TestKeyGroup b = new TestKeyGroup("name",1);

        System.out.println(a.equals(b));

        System.out.println();
        Set<TestKeyGroup> testKeyGroups = new HashSet<TestKeyGroup>();
        testKeyGroups.add(new TestKeyGroup("name",1));
        testKeyGroups.add(new TestKeyGroup("name",1));

        testKeyGroups.forEach(testKeyGroup -> {
            System.out.println(testKeyGroup.hashCode());
        });
        System.out.println(testKeyGroups.contains(new TestKeyGroup("name",1)));

        HashMap<TestKeyGroup,String> hashMap = new HashMap<>();
        hashMap.put(new TestKeyGroup("name",1),"value");
        System.out.println(hashMap.containsKey(new TestKeyGroup("name",1)));

//        add(new TestKeyGroup("name",1));
//        add(new TestKeyGroup("name",1));
//        add(new TestKeyGroup("name02",2));


    }
}
