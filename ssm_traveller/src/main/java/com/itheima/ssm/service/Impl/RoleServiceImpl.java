package com.itheima.ssm.service.Impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRole(int id) {
        return roleDao.findOtherRole(id);
    }

    @Override
    public Role findById(int roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public void addRoleToPermission(int roleId, int[] permissionIds) {
        for(int permission:permissionIds){
            roleDao.addRoleToPermission(roleId,permission);
        }
    }

}
