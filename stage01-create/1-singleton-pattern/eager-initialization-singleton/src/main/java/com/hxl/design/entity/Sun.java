package com.hxl.design.entity;

/**
 * 饿汉式单例 Sun
 * TODO: 推荐饿汉式！在类加载阶段就加载到内存里，避免懒汉式的双检加锁和初始化时带来的性能损耗
 * @author hengxiaoliang
 */
public class Sun {
    /**
     * 饿汉式: 在类加载阶段就实例化对象，并且放入内存中永生
     */
    private static final Sun SUN = new Sun();

    // 私有化无参构造器，禁止外部实例化从而破坏单例结构
    private Sun(){
    }

    /**
     * 对外提供获取单例 Sun的入口
     * @return 单例对象
     */
    public static Sun getSun() {
        return SUN;
    }
}
