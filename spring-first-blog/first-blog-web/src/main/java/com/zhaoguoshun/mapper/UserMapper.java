package com.zhaoguoshun.mapper;

import com.zhaoguoshun.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaoguoshun
 * @since 2020-10-16
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

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
     User userGetId(@Param("id") Integer ById);

     /**
      * 根据名称查找
      */

     List<User> getUserName(@Param("username") String userName);

     /**
      * 查找用户名和密码
      * @param username

      * @return
      */
     User loginSubmit(@Param("username") String username,@Param("password") String userPass);
}
