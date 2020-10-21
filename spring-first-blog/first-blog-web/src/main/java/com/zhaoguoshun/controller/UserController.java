package com.zhaoguoshun.controller;


import com.zhaoguoshun.entity.User;
import com.zhaoguoshun.response.Result;
import com.zhaoguoshun.service.AliOssService;
import com.zhaoguoshun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoguoshun
 * @since 2020-10-16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AliOssService ossService;


    @PostMapping("/insert")
    @CrossOrigin
    public String userInsert(@RequestParam String userName,
                             @RequestParam String userPass,
                             @RequestParam String userNickname,
                             @RequestParam String userEmail,User user){
        System.out.println("user===="+userName);
        user.setUserName(userName);
        user.setUserPass(userPass);
        user.setUserNickname(userNickname);
        user.setUserEmail(userEmail);

//        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setUserRegisterTime(new Date());
        System.out.println("User====》"+user);
        Boolean insertUser = userService.insertUser(user);
        if (insertUser==false){
            return "用户添加失败";
        }
        return "用户添加成功";
    }

    @GetMapping("/list/{id}")
    @CrossOrigin
    public String list(@PathVariable Integer id){
        User byId = userService.userGetId(id);
        if (byId!=null){
            return "成功"+byId;
        }
        return "查找失败";
    }

    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file){
        String upload = ossService.upload(file);
        return "文件上传成功:"+upload;
    }

    @GetMapping("/getUserName")
    public Result getUserName(@RequestParam String UserName){
        System.out.println("我是userName==>"+UserName);
        List<User> userName = userService.getUserName(UserName);
        if (userName.size()!=0){
            return Result.ok().data("username",userName).message("当前用户名已经存在");
        }
        return Result.error().message("");
    }
    @PostMapping("/loginSubmit")
    public Result loginSubmit(@RequestParam String UserName, @RequestParam String userPass,HttpSession session){
        System.out.println("username"+UserName+"password"+userPass);
        User user = userService.loginSubmit(UserName, userPass);
        if (user==null){
            return Result.error().data("user",user).message("用户名或者密码不正确");
        }
        session.setAttribute("user",user);
        return Result.ok().data("user",user).message("登录成功");
    }


    /**
     * 查询登录完成的数据
     * @param
     * @return
     */
    @GetMapping("/index")
    @CrossOrigin
    public String getUserIndex(HttpSession session){
        System.out.println(session.getAttribute("user"));

        return "成功了";
    }

}

