package com.zhaoguoshun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoguoshun
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String userPass;

    @ApiModelProperty(value = "用户名称")
    private String userNickname;

    @ApiModelProperty(value = "邮箱")
    private String userEmail;

    @ApiModelProperty(value = "头像")
    private String userAvatar;

    @ApiModelProperty(value = "状态 等于0为正常1为有风险")
    private Integer userStatus;

    @ApiModelProperty(value = "为关注的id 和用户id进行匹配")
    private Integer userFollowId;

    @ApiModelProperty(value = "为收藏id匹配，和文章id进行匹配")
    private Integer userCollectId;

    private Date userRegisterTime;

    private Date userLastLoginTime;


}
