package com.zhaoguoshun.service.impl;

import com.zhaoguoshun.entity.User;
import com.zhaoguoshun.mapper.UserMapper;
import com.zhaoguoshun.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoguoshun
 * @since 2020-10-16
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean insertUser(User user) {
        Boolean userInsert = userMapper.insertUser(user);
        if (userInsert==false){
            log.error("用户添加失败");
        }
        return userInsert;
    }

    /**
     * 根据id查找数据
     *
     * @param ById
     * @return
     */
    @Override
    public User userGetId(Integer ById) {
        return userMapper.userGetId(ById);
    }

    /**
     * 根据名称查找字段
     * @param userName
     * @return
     */
    @Override
    public List<User> getUserName(String userName) {
        List<User> username = userMapper.getUserName(userName);
        if (username!=null){
            log.error("该名称已存在");
        }
        return username;
    }

    /**
     * 登录
     *
     * @param username
     * @param userpass
     * @return
     */
    @Override
    public User loginSubmit(String username, String userpass) {
        User user = userMapper.loginSubmit(username, userpass);

        if (user==null){
            log.error("用户名和密码有错误");
        }
        return user;
    }
}
