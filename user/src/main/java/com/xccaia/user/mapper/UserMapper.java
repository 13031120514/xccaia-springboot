package com.xccaia.user.mapper;

import com.xccaia.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @ Author     ：xccaia
 * @ Date       ：2021-03-24
 * @ Description： swagger 用户信息处理
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("select * from user")
    List<User> findAll();


    List<User> queryAll();

}
