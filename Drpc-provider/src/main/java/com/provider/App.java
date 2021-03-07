package com.provider;

import com.bio.rpc.IHelloService;
import com.provider.impl.IHelloServiceImpl;
import com.provider.server.RpcProxyServer;

/**
 * @Author: drainli
 * @Description: direct by LiYuzhuo
 * @Date: 2021/2/28 21:34
 **/
public class App {

    public static void main(String[] args) {
        RpcProxyServer proxyServer = new RpcProxyServer() ;
        IHelloService iHelloService = new IHelloServiceImpl() ;
        proxyServer.publisher(iHelloService,8080);
    }

}
