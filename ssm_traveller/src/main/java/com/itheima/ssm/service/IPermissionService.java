package com.itheima.ssm.service;


import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findOtherPermission(int roleId);
}
