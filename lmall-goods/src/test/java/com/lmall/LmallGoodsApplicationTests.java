package com.lmall;

import com.lmall.service.DaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LmallGoodsApplication.class )
public class LmallGoodsApplicationTests {

    @Autowired
    private DaoService daoService;

    @Test
    public void test(){
        System.out.println(daoService.getTbUser().getPhone());

    }

}
