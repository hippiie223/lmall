package com.lmall.lmallportal;

import com.lmall.domain.FocusAndFans;
import com.lmall.mapper.FocusAndFansMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LmallPortalApplicationTests {
    @Autowired
    private FocusAndFansMapper focusAndFansMapper;
    @Test
    public void contextLoads() {
        System.out.println(focusAndFansMapper.getFocusList("王博文"));

    }

}
