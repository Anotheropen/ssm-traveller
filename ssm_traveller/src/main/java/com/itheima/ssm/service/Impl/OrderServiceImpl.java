package com.itheima.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service(value="orderServiceImpl")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(int id) {

        return orderDao.findById(id);
    }
}
