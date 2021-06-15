package com.xc.dto;

import java.util.List;

public class Student {

  private int id;
  private int age;

  public int getId() {
    return id;
  }

  public Student setId(int id) {
    this.id = id;
    return this;
  }

  public int getAge() {
    return age;
  }

  public Student setAge(int age) {
    this.age = age;
    return this;
  }


  public Student(int id, int age) {
    this.id = id;
    this.age = age;
  }

  public Student() {

  }


  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", age=" + age +
        '}';
  }
}
