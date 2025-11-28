package com.hxl.design.entity;

import java.util.Objects;

/**
 * 懒汉式单例 Sun
 * 1.最初版本是直接在 Get方法里判空并实例化返回
 * 2.由于前一个版本，在并发情况下，会导致多个线程同时进入判空条件，导致多次实例化对象，所以需要在 Get方法上加上同步锁synchronized
 * 3.TODO: 由于使用同步方法，导致每个线程想要 Get时都需要拿锁，导致性能降低，而更好的优化是，如果此时实例没有被创建再加锁并实例对象。
 *    如果已经实例化了，则直接拿对象即可，而不需要拿锁，这样子可以大大提升性能，也就是双重检锁。
 *    而由于编辑器和处理器为了优化性能，在不改变单线程程序执行结果的前提下，重新排列指令的执行顺序（CPU的执行速度远快于内存访问速度，为了充分利用CPU资源）
 *    所以为了避免指令重排后，引用被分配了地址，但该地址还未被实例化就将引用返回的情况，需要加上volatile来禁止指令重排，同时volatile还能保证可见性
 * @author hengxiaoliang
 */
public class Sun {

    // 没有final，但是需要加volatile
    private volatile static Sun sun;

    private Sun() {
    }

    /**
     * 双重加锁
     */
    public static Sun getSun() {
        // 如果已经实例化，则后续线程直接返回，而不会进入if语句去拿锁，这样子可以减少性能损耗
        if (Objects.isNull(sun)) {
            synchronized (Sun.class) {
                if (Objects.isNull(sun)) {
                    sun = new Sun();
                }
            }
        }
        return sun;
    }
}
