package com.itheima.ssm.Controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IRoleService;
import com.itheima.ssm.service.IUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Resource(name="userService")
    private IUserInfoService userInfoService;

    @Resource(name = "roleService")
    private IRoleService roleService;


    @RequestMapping(path = "/findAll")
    public ModelAndView findAll(){
        ModelAndView model=new ModelAndView();
        List<UserInfo> user=userInfoService.findAll();
        model.addObject("userList",user);
        model.setViewName("user-list");
        return model;
    }

    @RequestMapping(path = "/save")
    public String save(UserInfo userInfo){
        userInfoService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping(path = "/findById")
    public ModelAndView findById(int id){
        ModelAndView model=new ModelAndView();
        UserInfo user=userInfoService.findById(id);
        model.addObject("user",user);
        model.setViewName("user-show");
        return model;
    }

    @RequestMapping(path = "/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) int id){
        ModelAndView model=new ModelAndView();
        UserInfo user=userInfoService.findById(id);
        List<Role> role=roleService.findOtherRole(id);
        model.addObject("user",user);
        model.addObject("roleList",role);
        model.setViewName("user-role-add");
        return model;
    }


    @RequestMapping(path="/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)int userId,@RequestParam(name = "ids",required = true)int[] roleIds){
        userInfoService.addRoleToUser(userId,roleIds);
        return "redirect:findAll";
    }

}
