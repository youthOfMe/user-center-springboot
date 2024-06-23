package com.niuma.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niuma.usercenter.common.BaseResponse;
import com.niuma.usercenter.common.ErrorCode;
import com.niuma.usercenter.common.ResultUtils;
import com.niuma.usercenter.exception.BusinessException;
import com.niuma.usercenter.model.domain.User;
import com.niuma.usercenter.model.domain.request.UserLoginRequest;
import com.niuma.usercenter.model.domain.request.UserRegisterRequest;
import com.niuma.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.niuma.usercenter.constant.UserContant.USER_LOGIN_STATE;

/**
 * 用户接口
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String planetCode = userRegisterRequest.getPlanetCode();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        return ResultUtils.success(result);
    }

    /**
     * 登录
     * @param userLoginRequest
     * @param request
     * @return
     */
    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.userLogin(userAccount, userPassword, request);
        return ResultUtils.success(user);
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public BaseResponse<Integer> userLogout(HttpServletRequest request) {
        if (request == null) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        int result = userService.userLogout(request);
        return ResultUtils.success(result);
    }

    /**
     * 搜索用户
     * @param username
     * @param request
     * @return
     */
    @PostMapping("/search")
    public BaseResponse<List<User>> searchUsers(String username, HttpServletRequest request) {
        // 仅管理员可以查询
        if (!isAdmin(request)) {
            return ResultUtils.success(new ArrayList<>());
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // isNoneBlank 不为"" null " "
        if (StringUtils.isNoneBlank(username)) {
            queryWrapper.like("username", username);
        }
        List<User> userList = userService.list(queryWrapper);
        List<User> list = userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
        return ResultUtils.success(list);
    }

    /**
     * 获取当前登录用户信息
     * @param request
     * @return
     */
    @PostMapping("/current")
    public BaseResponse<User> getCurrentUser(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if (currentUser == null) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        Long userId = currentUser.getId();
        // todo 校验用户是否合法
        User user = userService.getById(userId);
        user = userService.getSafetyUser(user);
        return ResultUtils.success(user);
    }

    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteUsers(Integer id, HttpServletRequest request) {
        // 仅管理员可以删除
        if (!isAdmin(request)) {
            return ResultUtils.error(ErrorCode.NO_AUTH);
        }

        if (id <= 0) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        boolean isSuccess = userService.removeById(id);
        return ResultUtils.success(isSuccess);
    }

    /**
     * 是否为管理员
     * @param request
     * @return
     */
    private boolean isAdmin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        return user != null && user.getUserRole() == 1;
    }

}
