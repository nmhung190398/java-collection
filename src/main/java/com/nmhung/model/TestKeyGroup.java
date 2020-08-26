package com.nmhung.model;

public class TestKeyGroup extends GroupKey{
    private String name;
    private int age;

    public TestKeyGroup(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestKeyGroup() {
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
    public int hashCode() {
        return super.hashCode();
    }
}
