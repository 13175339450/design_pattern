package com.hxl.design;

import com.hxl.design.entity.Sun;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LazyInitializationTest {

    @Test
    public void eagerTest() {
        Sun sun1 = Sun.getSun();
        Sun sun2 = Sun.getSun();
        System.out.println(sun1);
        System.out.println(sun2);
    }
}
