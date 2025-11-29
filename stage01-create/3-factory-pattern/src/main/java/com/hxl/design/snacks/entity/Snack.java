package com.hxl.design.snacks.entity;

import lombok.Getter;

/**
 * 小吃的抽象类
 * @author hengxiaoliang
 */
@Getter
public abstract class Snack {

    private String name;

    public Snack(String name) {
        this.name = name;
    }

    /**
     * 制作小吃
     */
    public abstract void create();
}
