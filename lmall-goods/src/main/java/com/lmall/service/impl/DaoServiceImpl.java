package com.lmall.service.impl;

import com.lmall.domain.TbUser;
import com.lmall.domain.example.TbUserExample;
import com.lmall.mapper.TbUserMapper;
import com.lmall.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by reckywangbowen_i on 2018/12/10
 */

@Service
public class DaoServiceImpl implements DaoService {

    @Autowired
    private TbUserMapper mapper;


    @Override
    public TbUser getTbUser() {
        TbUserExample example = new TbUserExample();
        example.createCriteria().andUsernameEqualTo("admin");
        return mapper.selectByExample(example).get(0);
    }
}
