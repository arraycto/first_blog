package com.zhaoguoshun.service.impl;

import com.zhaoguoshun.entity.Menu;
import com.zhaoguoshun.mapper.MenuMapper;
import com.zhaoguoshun.service.MenuService;
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
 * @since 2020-10-20
 */
@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    /**
     * 查询所有的菜单
     *
     * @return
     */
    @Override
    public List<Menu> menuList() {
        List<Menu> menus = menuMapper.menuList();

        if (menus.size()==0){
            log.error("当前菜单是空的");
        }
        return menus;
    }
}
