package com.zhaoguoshun.service;

import com.zhaoguoshun.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoguoshun
 * @since 2020-10-16
 */
public interface UserService extends IService<User> {

    /**
     * 添加用户
     * @param user
     * @return
     */
    Boolean insertUser(User user);


    /**
     * 根据id查找数据
     * @param ById
     * @return
     */
    User userGetId(Integer ById);


    /**
     * 根据名称查找字段
     * @param userName
     * @return
     */
    List<User> getUserName(String userName);

    /**
     * 登录
     * @param username
     * @param userpass
     * @return
     */

    User loginSubmit(@Param("username") String username, @Param("userpass") String userpass);
}
