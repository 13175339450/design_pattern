package com.hxl.proxy.agent;

import com.hxl.proxy.entity.HouseOwner;
import com.hxl.proxy.entity.HouseTransaction;

import java.lang.reflect.Field;

/**
 * 房产中介
 *
 * @author hengxiaoliang
 */
public class HouseAgent implements HouseTransaction {

    // 中介名
    private String name;

    // 佣金比例 2%
    private double commissionRate = 0.02;

    // 房东
    private final HouseOwner houseOwner;

    public HouseAgent(HouseOwner houseOwner, String name) {
        this.houseOwner = houseOwner;
        this.name = name;
    }

    @Override
    public void viewHouse() {
        System.out.println("【中介服务】" + name + " 带您看房");
        System.out.println(" 中介先了解您的需求");
        System.out.println(" 中介带您看多套房子对比");

        // 调用真实对象的方法
        houseOwner.viewHouse();

        System.out.println(" 中介介绍周边配套设施\n");
    }

    @Override
    public void makeDeal() {
        System.out.println("【中介服务】" + name + " 协助交易");

        // 中介帮忙砍价
        System.out.println("  中介帮您砍价，原价：" + getHousePrice() + " 万");
        // 砍价5%
        double finalPrice = getHousePrice() * 0.95;
        System.out.println("  砍价后价格：" + finalPrice + " 万");

        // 中介收取佣金
        double commission = finalPrice * commissionRate;
        System.out.println("  中介收取佣金：" + commission + " 万");

        System.out.println("  中介提供合同审核服务");
        System.out.println("  中介协助办理过户手续\n");

        // 完成交易
        System.out.println("✅ 交易完成！您获得房子，房主收到钱，中介收到佣金");
    }

    // 中介特有的方法
    private Double getHousePrice() {
        // 利用反射获取房东的房子价格
        try {
            // 根据实例获取Class对象
            Class<? extends HouseOwner> clazz = houseOwner.getClass();
            // 获取对应的属性
            Field priceField = clazz.getDeclaredField("price");
            // 突破访问修饰符的限制
            priceField.setAccessible(true);
            // 获取属性值
            return (Double) priceField.get(houseOwner);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
