package com.hxl.design.snacks;

import com.hxl.design.snacks.entity.FrenchFries;
import com.hxl.design.snacks.entity.Snack;
import com.hxl.design.snacks.factory.SnackFactory;

/**
 * 薯条工厂
 * @author hengxiaoliang
 */
public class FrenchFriesFactory implements SnackFactory {

    @Override
    public Snack getSnack() {
        return new FrenchFries("薯条");
    }
}
