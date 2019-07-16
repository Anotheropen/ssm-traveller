package com.itheima.ssm.service.Impl;

import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;


    @Override
    public List<Product> findAll() {

        return productDao.findAll();
    }

    public void save(Product product){

        productDao.save(product);
    }

}
