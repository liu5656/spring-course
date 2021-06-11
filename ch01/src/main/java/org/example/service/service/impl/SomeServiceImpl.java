package org.example.service.service.impl;

import org.example.service.service.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行了someServiceImpl的dosome方法");
    }
}
