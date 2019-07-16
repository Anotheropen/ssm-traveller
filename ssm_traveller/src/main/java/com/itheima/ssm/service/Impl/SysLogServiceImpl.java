package com.itheima.ssm.service.Impl;


import com.itheima.ssm.dao.ISysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysLogService")
public class SysLogServiceImpl implements ISysLogService {

    @Resource(name = "sysLogDao")
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
