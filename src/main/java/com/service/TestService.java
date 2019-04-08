package com.service;

import com.model.WechatUser;

public interface TestService extends IService<WechatUser>{
    WechatUser getUsersById();
}
