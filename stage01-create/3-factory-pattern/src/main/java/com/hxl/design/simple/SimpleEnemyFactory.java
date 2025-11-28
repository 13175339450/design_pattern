package com.hxl.design.simple;

import com.hxl.design.entity.Plane;
import com.hxl.design.entity.Tank;
import com.hxl.design.entity.common.Enemy;

import java.util.Random;

/**
 * 简单工厂模式
 * 要么就很简单，如果逻辑复杂，拓展性要求高，就不要用简单工厂模式，
 * 因为会让实现更加复杂，耦合度变高，同时破坏 OOP开闭原则
 *
 * @author hengxiaoliang
 */
public class SimpleEnemyFactory {

    private int screenWidth;
    private Random random; //随机数

    public SimpleEnemyFactory(int screenWidth) {
        this.screenWidth = screenWidth;
        this.random = new Random();
    }

    public Enemy getEnemy(String type) {
        int x = random.nextInt(screenWidth);
        if ("Plane".equals(type)) {
            return new Plane(x);
        }
        if ("Tank".equals(type)) {
            return new Tank(x);
        }
        return null;
    }
}
