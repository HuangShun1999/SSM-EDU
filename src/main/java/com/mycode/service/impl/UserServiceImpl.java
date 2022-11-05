package com.mycode.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycode.domain.User;
import com.mycode.exception.MyException;
import com.mycode.service.UserService;
import com.mycode.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author huangshun
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-03 14:43:25
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        User user1 = userMapper.selectOne(queryWrapper);
        if(user1==null){
            throw new MyException("用户名不存在");
        }
        String s = SecureUtil.md5(user.getPassword());
        if(!(user1.getPassword().equals(s))){
            throw new MyException("密码错误");
        }
        return user1;
    }
}




