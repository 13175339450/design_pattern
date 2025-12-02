package com.hxl.design.entity;

/**
 * 建筑实体类
 *
 * @author hengxiaoliang
 */
public class Building {

    /**
     * 建筑组件: 地基、墙体、屋顶
     */
    private String foundation;
    private String wall;
    private String roof;

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void show() {
        System.out.println("建筑构建完成：");
        System.out.println("地基：" + foundation);
        System.out.println("墙体：" + wall);
        System.out.println("屋顶：" + roof);
    }

    @Override
    public String toString() {
        return "Building{" +
                "foundation='" + foundation + '\'' +
                ", wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}
