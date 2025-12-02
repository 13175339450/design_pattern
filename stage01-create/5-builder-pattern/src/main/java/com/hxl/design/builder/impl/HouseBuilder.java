package com.hxl.design.builder.impl;

import com.hxl.design.builder.Builder;
import com.hxl.design.entity.Building;

/**
 * 住宅建造者
 *
 * @author hengxiaoliang
 */
public class HouseBuilder implements Builder {

    private Building building;

    public HouseBuilder() {
        building = new Building();
    }

    @Override
    public void buildFoundation() {
        System.out.println("正在建立住宅地基...");
        building.setFoundation("住宅地基");
    }

    @Override
    public void buildWall() {
        System.out.println("正在建立住宅墙体...");
        building.setWall("住宅墙体");
    }

    @Override
    public void buildRoof() {
        System.out.println("正在建立住宅屋顶...");
        building.setRoof("住宅屋顶");
    }

    @Override
    public Building build() {
        return building;
    }
}
