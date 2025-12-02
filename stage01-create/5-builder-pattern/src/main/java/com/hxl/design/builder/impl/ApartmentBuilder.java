package com.hxl.design.builder.impl;

import com.hxl.design.builder.Builder;
import com.hxl.design.entity.Building;

/**
 * 公寓建造者
 *
 * @author hengxiaoliang
 */
public class ApartmentBuilder implements Builder {

    private Building building;

    public ApartmentBuilder() {
        building = new Building();
    }

    @Override
    public void buildFoundation() {
        System.out.println("正在建立公寓地基...");
        building.setFoundation("公寓地基");
    }

    @Override
    public void buildWall() {
        System.out.println("正在建立公寓墙体...");
        building.setWall("公寓墙体");
    }

    @Override
    public void buildRoof() {
        System.out.println("正在建立公寓屋顶...");
        building.setRoof("公寓屋顶");
    }

    @Override
    public Building build() {
        return building;
    }
}
