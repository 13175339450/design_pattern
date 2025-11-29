package com.hxl.design.snacks.entity;

/**
 * 饺子
 * @author hengxiaoliang
 */
public class Dumplings extends Snack{

    public Dumplings(String name) {
        super(name);
    }

    @Override
    public void create() {
        System.out.println("和面...");
        System.out.println(getName() + "制作好了...");
    }
}
