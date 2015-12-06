package com.cnblogs.yjmyzz.thrift.service.impl;

import com.cnblogs.yjmyzz.thrift.service.HelloService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;


@Service("helloServiceImpl")
public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String hello(String msg) throws TException {
        return "hello," + msg;
    }
}
