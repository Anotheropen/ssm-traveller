package com.itheima.ssm.Controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Resource(name = "productServiceImpl")
    private IProductService productService;


    @RequestMapping(path="/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Product> ps=productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping(path="/save")
    public String save(Product product){

        productService.save(product);

        return "redirect:findAll";
    }
}
