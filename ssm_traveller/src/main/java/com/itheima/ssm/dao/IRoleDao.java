package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {


    @Select("select * from role where id in(select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findById"))
    })
    List<Role> findRoleByUserId(int id);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id not in(select roleId from users_role where userId=#{id})")
    List<Role> findOtherRole(int id);


    @Select("select * from role where id=#{roleId}")
    Role findById(int roleId);

    @Insert("insert into role_permission(permissionId,roleId) values(#{permission},#{roleId})")
    void addRoleToPermission(@Param("roleId") int roleId, @Param("permission") int permission);
}
