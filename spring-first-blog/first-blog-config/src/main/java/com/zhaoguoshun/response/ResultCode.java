package com.zhaoguoshun.response;

public enum ResultCode implements CustomizeResultCode {

    /**
     * 20000代表成功
     */

    /*** 20000:"成功"*/
    SUCCESS(20000, "成功"),
    /*** 20001:"失败"*/
    ERROR(20001, "失败"),
    /*** 3005:"密码不正确!"*/
    PASS_NOT_CORRECT(3005, "密码不正确!请重新尝试!"),

    /*** 3006:"算数异常"*/
    ARITHMETIC_EXCEPTION(3006, "算数异常"),
    /*** 3007:"用户不存在"*/
    USER_NOT_FOUND_EXCEPTION(3007, "用户不存在"),
    /*** 3007:"部门不存在"*/
    DEPT_NOT_FOUND_EXCEPTION(3008, "未查询到部门信息"),
    /*** 3006:"尚未登录!"*/
    NOT_LOGIN(3006, "尚未登录!"),
    /*** 2005:"没有找到这一条历史信息!有人侵入数据库强制删除了!"*/
    INTRODUCTION_NOT_FOUND(2005, "没有找到这一条历史信息!有人侵入数据库强制删除了!"),
    /*** 500:服务端异常**/
    INTERNAL_SERVER_ERROR(500, "服务器冒烟了...要不等它降降温后再来访问?"),
    UNKNOW_SERVER_ERROR(2001, "未知异常,请联系管理员!");
    ;

    private Integer code;

    private String message;
    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
