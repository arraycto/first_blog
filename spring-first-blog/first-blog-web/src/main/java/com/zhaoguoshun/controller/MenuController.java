package com.zhaoguoshun.controller;


import com.zhaoguoshun.entity.Menu;
import com.zhaoguoshun.response.Result;
import com.zhaoguoshun.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoguoshun
 * @since 2020-10-20
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    @CrossOrigin
    public Result listMenu(){
        System.out.println("我是菜单数据");
        List<Menu> menus = menuService.menuList();
        if (menus==null){
            return Result.error().data("menu",menus).message("当前菜单是空的，或没有查到");
        }
        return Result.ok().data("menu",menus).message("菜单查询成功");
    }
}

