package com.cnblogs.yjmyzz.thrift.service.impl;

import com.cnblogs.yjmyzz.thrift.service.HealthService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;


@Service("healthServiceImpl")
public class HealthServiceImpl implements HealthService.Iface {
    @Override
    public String ping() throws TException {
        return "pong";
    }
}
