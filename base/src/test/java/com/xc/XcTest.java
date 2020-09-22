package com.xc;


import com.xc.mapper.UserMapper;
import com.xc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class XcTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void monthExecute() {
        List<User> users = userMapper.GetUserbyId(1);
        System.out.println(users);
    }


}
