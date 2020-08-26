package com.nmhung.model;

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Student){
            Student student = (Student) obj;
            return student.id.equals(this.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        String name = Student.class.getSimpleName();
        System.out.println("name : " + name );
        return Objects.hash(this.getClass().getSimpleName());
    }
}
