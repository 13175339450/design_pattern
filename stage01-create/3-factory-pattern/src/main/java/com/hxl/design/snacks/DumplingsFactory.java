package com.hxl.design.snacks;

import com.hxl.design.snacks.entity.Dumplings;
import com.hxl.design.snacks.entity.Snack;
import com.hxl.design.snacks.factory.SnackFactory;

/**
 * 饺子工厂
 * @author hengxiaoliang
 */
public class DumplingsFactory implements SnackFactory {

    @Override
    public Snack getSnack() {
        return new Dumplings("饺子");
    }
}
