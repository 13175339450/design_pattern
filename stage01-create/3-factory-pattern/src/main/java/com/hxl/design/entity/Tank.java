package com.hxl.design.entity;

import com.hxl.design.entity.common.Enemy;

/**
 * 坦克
 */
public class Tank extends Enemy {
    /**
     * 初始化Tank
     *
     * @param x 地图横坐标
     */
    public Tank(Integer x) {
        // 纵坐标都在最上方 0 开始
        super(x, 0);
    }

    @Override
    public void show() {
        System.out.println("Tank出现了，坐标为: (" + getX() + "," + getY() + ")");
    }
}
