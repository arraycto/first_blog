package com.zhaoguoshun.mapper;

import com.zhaoguoshun.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaoguoshun
 * @since 2020-10-20
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询所有的菜单
     * @return
     */
    List<Menu> menuList();
}
