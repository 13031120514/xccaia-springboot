package com.xc.dto;

import java.util.List;

public class User {

  private int id;
  private int age;
  private String name;
  private List<User1> user1List;
  private User1 user1;

  public List<User1> getUser1List() {
    return user1List;
  }

  public User setUser1List(List<User1> user1List) {
    this.user1List = user1List;
    return this;
  }

  public int getId() {
    return id;
  }

  public User setId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public User setAge(int age) {
    this.age = age;
    return this;
  }

  public User1 getUser1() {
    return user1;
  }

  public User setUser1(User1 user1) {
    this.user1 = user1;
    return this;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", age=" + age +
        ", name='" + name + '\'' +
        '}';
  }
}
