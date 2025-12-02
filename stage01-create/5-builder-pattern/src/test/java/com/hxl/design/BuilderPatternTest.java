package com.hxl.design;

import com.hxl.design.builder.Director;
import com.hxl.design.builder.impl.ApartmentBuilder;
import com.hxl.design.builder.impl.HouseBuilder;
import com.hxl.design.entity.Building;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 建造者模式测试类
 *
 * @author hengxiaoliang
 */
@SpringBootTest
public class BuilderPatternTest {

    @Test
    public void testBuilder() {
        Director director = new Director(new HouseBuilder());
        Building housing = director.construct();
        System.out.println(housing);

        System.out.println("===============================");

        director.setBuilder(new ApartmentBuilder());
        Building apartment = director.construct();
        System.out.println(apartment);
    }
}
