package com.hxl.design.builder;

import com.hxl.design.entity.Building;

/**
 * 指挥者类
 *
 * @author hengxiaoliang
 */
public class Director {

    // 抽象建造者
    private Builder builder;

    // 传入具体建造者（依赖抽象，不依赖具体实现，符合开闭原则）
    public Director(Builder builder) {
        this.builder = builder;
    }

    // 设置具体建造者
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    // 构建流程（固定顺序：地基→墙体→屋顶）
    public Building construct() {
        builder.buildFoundation();
        builder.buildWall();
        builder.buildRoof();
        // 返回成品
        return builder.build();
    }
}
