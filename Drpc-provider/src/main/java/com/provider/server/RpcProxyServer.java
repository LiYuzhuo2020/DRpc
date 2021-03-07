package com.provider.server;

import com.provider.handler.RpcProxyThreadHandler;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: drainli
 * @Description: direct by LiYuzhuo
 * @Date: 2021/2/27 22:06
 **/
public class RpcProxyServer {

    /**
     *  服务发布的方法
     * @param service 发布的对象
     * @param port 发布的端口
     */
    public void publisher(Object service,int port) {

        ServerSocket serverSocket = null ;
        // 构建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10) ;
        try {
            serverSocket = new ServerSocket(port) ;
            while (true){
                // 等待客户端的连接
                //BIO
                  Socket accept = serverSocket.accept() ;

                executorService.execute(new RpcProxyThreadHandler(service,accept));
            }

        }catch (Exception e){

        }

    }

}
