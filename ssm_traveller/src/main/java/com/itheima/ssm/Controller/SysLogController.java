package com.itheima.ssm.Controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(path = "/sysLog")
public class SysLogController {

    @Resource(name = "sysLogService")
    private ISysLogService sysLogService;

    @RequestMapping(path = "/findAll")
    public ModelAndView findAll(){
        ModelAndView model=new ModelAndView();
        List<SysLog> list= sysLogService.findAll();
        model.addObject("sysLogs",list);
        model.setViewName("syslog-list");
        return model;
    }
}
