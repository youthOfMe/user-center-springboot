package com.niuma.usercenter.service;

public interface UserService {

    /**
     * 用户注册
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @param planetCode 新用户ID
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);
}
