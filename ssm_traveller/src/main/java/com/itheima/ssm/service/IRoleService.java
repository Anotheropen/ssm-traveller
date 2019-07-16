package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();

    void save(Role role);

    List<Role> findOtherRole(int id);

    Role findById(int roleId);

    void addRoleToPermission(int roleId, int[] permissionIds);
}
