package com.example.design.base;

import com.example.design.common.enums.ShipmentOrderMainFieldEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@ExtendWith(MockitoExtension.class)
public class StringTest {

    /**
     * 格式化字串形式
     */
    private static final String FORMAT = "%s_%s";

    @Test
    @DisplayName("循环中拼接字符串 不使用StringBuilder")
    void test() {
        long t1 = System.currentTimeMillis();
        String str = "jia";
        for (int i = 0; i < 50000; i++) {
            String s = String.valueOf(i);
            str += s;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("+ cost：" + (t2 - t1));
    }


    @Test
    void test02() {
        String a  = "ab";
        String b = "a" + "b";
        System.out.println(a == b);
    }

    @Test
    @DisplayName("字符串常量池在堆上，第一次使用时，常量池引用第一次使用的地址")
    void testIntern01() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1000000000");
        s3.intern();
        String s4 = "11000000000";
        System.out.println(s3 == s4);
    }

    @Test
    @DisplayName("字符串常量池在堆上，第一次使用时，常量池引用第一次使用的地址，本场景不是第一次出现了，所以地址不同 s3 != s4 false")
    void testIntern02(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1000000000");
        String s4 = "11000000000";
        s3.intern();
        System.out.println(s3 == s4);
    }

    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];

    @Test
    @DisplayName("大量重复字符串动态生成，使用intern节省内存")
    void testIntern03(){
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < DB_DATA.length; i++) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
//            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])); //4968ms
            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern(); //1233ms
        }
        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();
    }


    @Test
    @DisplayName("字符串长度最大限制")
    void testIntern04() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65535; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }

    @Test
    void testIntern() {
        String s1 = new String("a");
        s1.intern();
        String s2 ="a";
        System.out.println(s1 == s2);

        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3 == s4);

        String s5 = new String("a");

        String s6 = new String("a");
        System.out.println(s5 == s6);
    }

    public static void main(String[] args) {
        List<ShipmentOrderMainFieldEnum> shipmentOrderMainFieldEnums = Lists.newArrayList(ShipmentOrderMainFieldEnum.ID, ShipmentOrderMainFieldEnum.CARRIER_NAME, ShipmentOrderMainFieldEnum.SHIPMENT_ORDER_NO);
        System.out.println(buildMainColumnsSql(shipmentOrderMainFieldEnums));


        System.out.println(String.format(FORMAT, "70", "10@1", 00));

        System.out.println(StringUtils.joinWith("_", "70", "10@1", null));

        List<String> groupKeys = Lists.newArrayList("A", "B", "C", "D", "E");
        String groupKey = buildGroupKey(groupKeys);
        System.out.println(groupKey);
    }


    private static String buildGroupKey(List<String> groupKeys) {
        String groupKey = "";
        if (groupKeys.contains("A")) {
            groupKey = StringUtils.join(groupKey, "A");
        }
        if (groupKeys.contains("B")) {
            groupKey = StringUtils.join(groupKey, "B");
        }
        if (groupKeys.contains("C")) {
            groupKey = StringUtils.join(groupKey, "C");
        }
        if (groupKeys.contains("D")) {
            groupKey = StringUtils.join(groupKey, "D");
        }
        if (groupKeys.contains("E")) {
            groupKey = StringUtils.join(groupKey, "E");
        }
        return groupKey;
    }

    private static String buildMainColumnsSql(List<ShipmentOrderMainFieldEnum> shipmentOrderMainFieldEnums) {
        if (CollectionUtils.isNotEmpty(shipmentOrderMainFieldEnums)) {
            shipmentOrderMainFieldEnums.add(ShipmentOrderMainFieldEnum.ID);
            shipmentOrderMainFieldEnums.add(ShipmentOrderMainFieldEnum.SHIPMENT_ORDER_NO);

            return StringUtils.join(shipmentOrderMainFieldEnums.stream()
                            .map(ShipmentOrderMainFieldEnum::getFieldName).collect(Collectors.toList())
                    , ",");
        }
        return null;
    }
}
