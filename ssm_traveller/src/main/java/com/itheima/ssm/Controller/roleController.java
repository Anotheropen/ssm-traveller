package com.itheima.ssm.Controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IPermissionService;
import com.itheima.ssm.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping(path = "/role")
@Controller
public class roleController {

    @Resource(name = "roleService")
    private IRoleService roleService;

    @Resource(name = "permissionService")
    private IPermissionService permissionService;

    @RequestMapping(path = "/findAll")
    public ModelAndView findAll(){
        ModelAndView model=new ModelAndView();
        List<Role> list= roleService.findAll();
        model.addObject("roleList",list);
        model.setViewName("role-list");
        return model;
    }

    @RequestMapping(path = "/save")
    public String save(Role role){

        roleService.save(role);

        return "redirect:findAll";
    }


    @RequestMapping(path = "/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) int roleId){
        ModelAndView model=new ModelAndView();
//        System.out.println(roleId);
//        Role role=roleService.findById(roleId);
//        System.out.println(role.getId());
        List<Permission> permissions=permissionService.findOtherPermission(roleId);
        model.addObject("roleId",roleId);
        model.addObject("permissionList",permissions);
        model.setViewName("role-permission-add");
        return model;
    }

    @RequestMapping(path = "/addRoleToPermission")
    public String addRoleToPermission(@RequestParam(name="roleId",required = true)int roleId,@RequestParam(name = "ids",required = true)int[] permissionIds){
        roleService.addRoleToPermission(roleId,permissionIds);
        return "redirect:findAll";
    }

}
