package com.bio.rpc.pojo;

import java.io.Serializable;

/**
 * @Author: drainli
 * @Description: direct by LiYuzhuo
 * @Date: 2021/2/27 22:48
 **/
public class RpcRequest implements Serializable {

    private final static long SERIA_VERSION = 1l ;

    private String className ;

    private String methodName ;

    private Object[] params ;

    private Class[] types ;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
