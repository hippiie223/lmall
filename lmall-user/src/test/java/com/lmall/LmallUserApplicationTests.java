package com.lmall;

import com.lmall.domain.example.UsersExample;
import com.lmall.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LmallUserApplicationTests {
    @Autowired
    private UsersMapper usersMapper;
    @Test
    public void contextLoads() {
        UsersExample example = new UsersExample();
        example.createCriteria().andPhoneEqualTo("13260669530");
        System.out.println(usersMapper.selectByExample(example));
    }

}
