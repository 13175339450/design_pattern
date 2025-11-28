package com.hxl.design.entity.common;

/**
 * 敌人的抽象类，自下而上的，将公共的部分抽取出来
 */
public abstract class Enemy {
    /**
     * 敌人坐标
     */
    private Integer x;
    private Integer y;

    public Enemy(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    // 抽象方法，在屏幕地图上展示
    public abstract void show();

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
