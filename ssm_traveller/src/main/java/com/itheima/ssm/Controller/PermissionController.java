package com.itheima.ssm.Controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(path = "/permission")
public class PermissionController {

    @Resource(name = "permissionService")
    private IPermissionService permissionService;

    @RequestMapping(path = "/findAll")
    public ModelAndView findAll(){
        ModelAndView model=new ModelAndView();
        List<Permission> list= permissionService.findAll();
        model.addObject("permissionList",list);
        model.setViewName("permission-list");
        return model;
    }

    @RequestMapping(path = "/save")
    public String save(Permission permission){

        permissionService.save(permission);

        return "redirect:findAll";
    }

}
