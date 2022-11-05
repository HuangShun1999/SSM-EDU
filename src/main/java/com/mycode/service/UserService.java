package com.mycode.service;

import com.mycode.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author huangshun
* @description 针对表【user】的数据库操作Service
* @createDate 2022-11-03 14:43:25
*/
public interface UserService extends IService<User> {

    User login(User user);

}
