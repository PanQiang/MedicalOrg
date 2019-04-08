package com.service.impl;

import com.mapper.TestMapper;
import com.model.WechatUser;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("testService")
public class TestServiceImpl extends BaseService<WechatUser> implements TestService{

    @Autowired
    TestMapper testMapper;

    @Override
    public WechatUser getUsersById() {
        WechatUser user = testMapper.getUsersById();
        return user;
    }
}
