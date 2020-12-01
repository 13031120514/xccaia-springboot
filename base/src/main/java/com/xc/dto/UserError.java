package com.xc.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class UserError {
    public int Id ;
    private int age ;
    private String name;

    public int getId() {
        return Id;
    }

    public UserError setId(int id) {
        this.Id = id;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserError setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserError setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + Id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

//        UserError user=new UserError();
//        user.setId(11);
        try {
//            String jsonString = new ObjectMapper().writeValueAsString(user);
//            System.out.println(jsonString);

            String jsonString="{\"Id\":11,\"name\":null,\"age\":11}";
            jsonString="{\"id\":11,\"name\":null,\"age\":11}";
//             jsonString="{\"id\":11}";
            UserError userError = new ObjectMapper().readValue(jsonString, UserError.class);
            System.out.println(userError);
            System.out.println(userError);

            jsonString="{\"id\":11,\"id11\":11,\"name\":null,\"age\":11}";
//             jsonString="{\"id\":11}";
             userError = new ObjectMapper().readValue(jsonString, UserError.class);
            System.out.println(userError);
            System.out.println(userError);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
