package com.xc.mongo;

import com.xc.dto.Student;

public class XcDocumnet extends DynamicDocument {


    String name;
    int age;

    Student student;

    public String getName() {
        return name;
    }

    public XcDocumnet setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public XcDocumnet setAge(int age) {
        this.age = age;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public XcDocumnet setStudent(Student student) {
        this.student = student;
        return this;
    }

    @Override
    public String toString() {
        return "XcDocumnet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", student=" + student +
                '}';
    }
}
