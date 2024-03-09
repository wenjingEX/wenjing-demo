package com.wj.service;

import com.wj.dto.UserLoginDTO;
import com.wj.entity.User;

public interface UserService {


    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
