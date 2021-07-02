package com.xccaia.user.model;

import lombok.Data;

import javax.persistence.Table;


/**
 * @ Author     ：xccaia
 * @ Date       ：2021-03-24
 * @ Description： swagger 用户信息模型
 */
@Data
@Table(name = "user")
public class User {

  private int id;
  private String name;
  private int age;

}
