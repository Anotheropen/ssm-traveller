package com.itheima.ssm.Controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

    @Resource(name = "orderServiceImpl")
    private IOrderService orderService;

//    @RequestMapping(path="/findAll")
//    public ModelAndView findAll(){
//        ModelAndView model=new ModelAndView();
//        List<Orders> list= orderService.findAll();
//        model.addObject("ordersList",list);
//        model.setViewName("orders-list");
//        return model;
//    }

    @RequestMapping(path="/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name="size",required = true,defaultValue = "4")Integer size){
        ModelAndView model=new ModelAndView();
        List<Orders> list= orderService.findAll(page,size);
        PageInfo info=new PageInfo(list);
        model.addObject("pageInfo",info);
        model.setViewName("orders-list");
        return model;
    }

    @RequestMapping(path = "/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true,defaultValue = "1")Integer id){
        ModelAndView model=new ModelAndView();
        Orders order=orderService.findById(id);
        model.addObject("orders",order);
        model.setViewName("orders-show");
        return model;
    }

}
