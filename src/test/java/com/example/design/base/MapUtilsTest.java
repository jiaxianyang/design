package com.example.design.base;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
class MapUtilsTest {

    @Test
    void test() {
        Map<String, String> map = Maps.newHashMap();
        map.put("flag", "true");
        map.put("flag2", "false");

        if (MapUtils.getBoolean(map, "flag")) {
            System.out.println(MapUtils.getBoolean(map, "flag"));

        }
        if (!MapUtils.getBoolean(map, "flag2")) {
            System.out.println(MapUtils.getBoolean(map, "flag2"));
        }
        Integer flag3 = MapUtils.getInteger(map, "flag3");
        System.out.println(flag3);
    }
}
