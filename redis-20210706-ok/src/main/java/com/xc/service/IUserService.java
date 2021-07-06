package com.xc.service;

import com.xc.entity.User;
import java.util.List;

public interface IUserService {


  List<User> getAll();

  User getOne(String id);

  void clear();

}
