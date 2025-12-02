package com.hxl.design.builder;

import com.hxl.design.entity.Building;

/**
 * 抽象建造者
 *
 * @author hengxiaoliang
 */
public interface Builder {

    // 构建地基
    void buildFoundation();

    // 构建墙体
    void buildWall();

    // 构建屋顶
    void buildRoof();

    Building build();
}
