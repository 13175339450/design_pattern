package com.hxl.design.standard;

import com.hxl.design.entity.Tank;
import com.hxl.design.entity.common.Enemy;
import com.hxl.design.standard.factory.EnemyFactory;

import java.util.Random;

public class TankFactory implements EnemyFactory {

    @Override
    public Enemy getEnemy(int screenWidth) {
        Random random = new Random();
        return new Tank(random.nextInt(screenWidth));
    }

}
