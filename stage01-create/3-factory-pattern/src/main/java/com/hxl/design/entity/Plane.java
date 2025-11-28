package com.hxl.design.entity;

import com.hxl.design.entity.common.Enemy;

/**
 * 飞机
 */
public class Plane extends Enemy {

    /**
     * 初始化飞机
     *
     * @param x 地图横坐标
     */
    public Plane(Integer x) {
        // 纵坐标都在最上方 0 开始
        super(x, 0);
    }

    @Override
    public void show() {
        System.out.println("Plane出现了，坐标为: (" + getX() + "," + getY() + ")");
    }
}
