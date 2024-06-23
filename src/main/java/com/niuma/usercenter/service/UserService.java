package com.niuma.usercenter.service;

import com.niuma.usercenter.model.domain.User;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 退出登录
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);
}
