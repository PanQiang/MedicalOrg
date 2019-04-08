package com.mapper;

import com.model.WechatUser;
import com.util.MyMapper;

public interface TestMapper extends MyMapper<WechatUser> {
    WechatUser getUsersById();
}
