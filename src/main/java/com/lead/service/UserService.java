package com.lead.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lead.model.domain.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
* @author my_computer
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-09-12 23:14:47
*/
public interface UserService extends IService<User> {
    User getSafetyUser(User originUser);

    List<User> searchUsersByTags(List<String> list);

    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    int userLogout(HttpServletRequest request);

    User getLogininUser(HttpServletRequest request);

    boolean isAdmin(HttpServletRequest request);

    int updateUser(User user, User loginUser);
}
