package com.zhaoguoshun.service;

import com.zhaoguoshun.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoguoshun
 * @since 2020-10-20
 */
public interface MenuService extends IService<Menu> {

    /**
     * 查询所有的菜单
     * @return
     */
    List<Menu> menuList();
}
