package com.hxl.design.standard.factory;

import com.hxl.design.entity.common.Enemy;

/**
 * 敌人工厂接口
 */
public interface EnemyFactory {

    Enemy getEnemy(int screenWidth);

}
