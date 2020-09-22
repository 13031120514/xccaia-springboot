package com.xc.mapper;

import com.xc.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> GetUserbyId(@Param("id") Integer id);
}
