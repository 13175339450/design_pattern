package com.hxl.proxy.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理中介
 *
 * @author hengxiaoliang
 */
public class HouseDynamicAgent implements InvocationHandler {

    // 中介名
    private String name;

    // 被代理的目标对象（房东）
    private Object target;

    public HouseDynamicAgent(String name, Object target) {
        this.name = name;
        this.target = target;
    }

    /**
     * 动态代理方法,会在 调用被代理对象方法时 执行
     * 可能会执行多次,比如房东调用 viewHouse()方法时，会先执行下面代理对象的invoke方法里逻辑，也就是在执行 viewHouse()方法之前，添加中介提供的额外服务。
     * 之后调用makeDeal()方法时，还会会先执行下面代理对象的invoke方法里逻辑，也就是在执行 makeDeal()方法之前，添加中介提供的额外服务。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 调用前：中介提供额外服务
        if ("viewHouse".equals(method.getName())) {
            System.out.println("【中介服务开始】");
            System.out.println("中介带你看房");
        } else if (method.getName().equals("makeDeal")) {
            System.out.println("中介帮你谈价格");
        }

        // 调用真实对象的方法（房东）
        Object result = method.invoke(target, args);

        // 调用后：中介提供后续服务
        if ("makeDeal".equals(method.getName())) {
            System.out.println("中介办理过户手续");
            System.out.println("【中介服务结束】\n");
        }

        return result;
    }
}
