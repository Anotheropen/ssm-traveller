package com.itheima.ssm.service;


import com.itheima.ssm.domain.UserInfo;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserInfoService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(int id);

    void addRoleToUser(int userId, int[] roleIds);
}
