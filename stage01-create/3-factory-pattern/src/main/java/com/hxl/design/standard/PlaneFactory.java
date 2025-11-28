package com.hxl.design.standard;

import com.hxl.design.entity.Plane;
import com.hxl.design.entity.common.Enemy;
import com.hxl.design.standard.factory.EnemyFactory;

import java.util.Random;

public class PlaneFactory implements EnemyFactory {

    @Override
    public Enemy getEnemy(int screenWidth) {
        Random random = new Random();
        return new Plane(random.nextInt(screenWidth));
    }

}
