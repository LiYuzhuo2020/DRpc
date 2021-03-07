package com.provider.impl;

import com.bio.rpc.IHelloService;

/**
 * @Author: drainli
 * @Description: direct by LiYuzhuo
 * @Date: 2021/2/28 22:11
 **/
public class IHelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String txt) {
        return "Hello " + txt ;
    }

}
