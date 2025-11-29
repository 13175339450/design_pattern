package com.hxl.design.snacks.entity;

/**
 * 薯条
 *
 * @author hengxiaoliang
 */
public class FrenchFries extends Snack {

    public FrenchFries(String name) {
        super(name);
    }

    @Override
    public void create() {
        System.out.println("起锅烧油...");
        System.out.println(getName() + "制作好了...");
    }
}
