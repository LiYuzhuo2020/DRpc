package com.provider.handler;

import com.bio.rpc.pojo.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Author: drainli
 * @Description: 用以解决IO阻塞问题
 * @Date: 2021/2/28 21:57
 **/
public class RpcProxyThreadHandler implements Runnable {

    Object service ;
    Socket socket ;

    public RpcProxyThreadHandler(Object service, Socket socket) {
        this.service = service;
        this.socket = socket;
    }

    @Override
    public void run() {

        try(ObjectInputStream ins = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream())) {

            // 拿到客户端的请求信息
            RpcRequest rpcRequest = (RpcRequest) ins.readObject() ;
            Object result = invoke(rpcRequest) ;
            // 将请求处理结果返回给客户端
            os.writeObject(result);

            os.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     *  反射调用服务端相关的方法
     * @param rpcRequest 请求的相关信息
     * @return 服务端处理的结果
     */
    private Object invoke(RpcRequest rpcRequest) {
        try {
            Class clazz = Class.forName(rpcRequest.getClassName()) ;
            Method method = clazz.getMethod(rpcRequest.getMethodName(),rpcRequest.getTypes()) ;

            return method.invoke(service,rpcRequest.getParams()) ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            return null ;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();

            return null ;
        } catch (IllegalAccessException e) {
            e.printStackTrace();

            return null ;
        } catch (InvocationTargetException e) {
            e.printStackTrace();

            return null ;
        }
    }
}
