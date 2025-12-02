package com.hxl.proxy;

import com.hxl.proxy.agent.HouseAgent;
import com.hxl.proxy.agent.HouseDynamicAgent;
import com.hxl.proxy.entity.HouseOwner;
import com.hxl.proxy.entity.HouseOwnerOne;
import com.hxl.proxy.entity.HouseOwnerTwo;
import com.hxl.proxy.entity.HouseTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;

/**
 * 代理模式测试
 *
 * @author hengxiaoliang
 */

@SpringBootTest
public class ProxyTest {

    @Test
    public void testStaticProxy() {
        // 房东
        HouseOwner houseOwner = new HouseOwner("小王", "上海", 300.0);
        HouseAgent agent = new HouseAgent(houseOwner, "中介小李");
        agent.viewHouse();
        agent.makeDeal();
    }

    @Test
    public void testDynamicProxy() {
        // 创建两个真实对象
        HouseTransaction owner1 = new HouseOwnerOne("张三", "浙江", 400.0);
        HouseTransaction owner2 = new HouseOwnerTwo("李四", "安徽", 350.0);

        // 创建动态代理（不需要为每个房主写代理类）
        HouseTransaction agentOne = createProxy("中介小王", owner1);
        System.out.println(" 通过中介小王找房东张三买房：");
        agentOne.viewHouse();
        agentOne.makeDeal();

        HouseTransaction agentTwo = createProxy("中介小李", owner2);
        System.out.println(" 通过中介小李找房东李四买房：");
        agentTwo.viewHouse();
        agentTwo.makeDeal();
    }

    /**
     * 创建房屋交易的动态代理对象
     * <p>
     * 该方法使用Java动态代理机制为指定的房屋交易目标对象创建一个代理实例。
     * 代理对象会拦截所有方法调用，并通过自定义的调用处理器进行增强处理。
     *
     * @param name   代理名称，用于标识代理对象的身份信息
     * @param target 被代理的目标房屋交易对象，代理将转发所有方法调用给此对象
     * @return 返回一个实现了HouseTransaction接口的代理对象
     */
    private static HouseTransaction createProxy(String name, HouseTransaction target) {
        return (HouseTransaction) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),  // 类加载器
                new Class[]{HouseTransaction.class}, // 要实现的接口
                new HouseDynamicAgent(name, target)// 调用处理器
        );
    }
}
