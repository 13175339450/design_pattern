package com.hxl.design;

import com.hxl.design.entity.Plane;
import com.hxl.design.entity.common.Enemy;
import com.hxl.design.simple.SimpleEnemyFactory;
import com.hxl.design.standard.PlaneFactory;
import com.hxl.design.standard.TankFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 此按理模拟飞机大战这类游戏，在屏幕上方会出现敌人（坦克、飞机...），以左上方为坐标原点
 * 所以敌人出现时的y都是0，而x是随机的，但要限制在屏幕宽度内。
 */
@SpringBootTest
public class FactoryPatternTest {

    /**
     * 测试简单工厂模式
     */
    @Test
    public void testSimpleFactory() {
        int screenWidth = 100;
        SimpleEnemyFactory simpleEnemyFactory = new SimpleEnemyFactory(screenWidth);
        for (int i = 0; i < 5; i++) {
            Enemy tank = simpleEnemyFactory.getEnemy("Tank");
            tank.show();
        }

        for (int i = 0; i < 5; i++) {
            Enemy plane = simpleEnemyFactory.getEnemy("Plane");
            plane.show();
        }
    }

    /**
     * 测试工厂模式（标准）
     */
    @Test
    public void testFactory() {
        int screenWidth = 100;

        TankFactory tankFactory = new TankFactory();
        for (int i = 0; i < 5; i++) {
            Enemy tank = tankFactory.getEnemy(screenWidth);
            tank.show();
        }

        PlaneFactory planeFactory = new PlaneFactory();
        for (int i = 0; i < 5; i++) {
            Enemy plane = planeFactory.getEnemy(screenWidth);
            plane.show();
        }
    }
}
