package com.itheima.ssm.service.Impl;

import com.itheima.ssm.dao.IUserInfoDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

import java.util.List;

@Service(value = "userService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDao userInfoDao;

    @Resource(name = "passwordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo findById(int id) {

        return userInfoDao.findById(id);
    }

    @Override
    public void addRoleToUser(int userId, int[] roleIds) {

        for(int roleId:roleIds){
            userInfoDao.addRoleToUser(userId,roleId);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;

        try{
            userInfo=userInfoDao.findByUsername(username);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(userInfo.getPassword());
        List<Role> role=userInfo.getRoles();

        User user=new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(role));
//        System.out.println(user.getUsername());
//        System.out.println(userInfo.getPassword()==user.getPassword());
        return user;
    }

    private  List<SimpleGrantedAuthority>  getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

//    private  List<SimpleGrantedAuthority>  getAuthority() {
//        List<SimpleGrantedAuthority> list=new ArrayList<>();
//        list.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return list;
//    }
}
