package com.example.design.base;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class FanXingTest {

    @Test
    @DisplayName("泛型测试")
    void test() {
        List list = new ArrayList<>();
        list.add(11);
        list.add("ssss");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String) list.get(i));
        }
    }


    @Test
    @DisplayName("测试泛型擦除后 可以存放不同类型, List<String> 可以赋值 List")
    void test2() {
        List<String> listString = new ArrayList<>();
        testDiffTypeAddToFanXing(listString);
        System.out.println(listString);
    }

    public static void  testDiffTypeAddToFanXing (List list) {
        list.add("jia");
        list.add(666);
    }

    @Test
    @DisplayName("Object 不可以存放不同类型, List<String> 不能赋值 List<Object>")
    void test3() {
        List<String> listString = new ArrayList<>();
        //编译出错
//        testDiffTypeAddToObject(listString);

        System.out.println(listString);
    }

    public static void  testDiffTypeAddToObject (List<Object> list) {
        list.add("jia");
        list.add(666);
    }

    @Test
    @DisplayName("List<?> 由于不确定列表中元素的具体类型， 只能从这种列表中读取数据，而不能往里面添加除了null 之外的任何元素")
    void test4() {
        List<String> listString = new ArrayList<>();
        //编译出错
        testDiffTypeAddToFanxing2(listString);

        System.out.println(listString);
    }

    public static void  testDiffTypeAddToFanxing2 (List<?> list) {
        //编译出错
//        list.add("jia");
//        list.add(666);
        list.get(0);
    }

    @SneakyThrows
    @Test
    @DisplayName("通过反射可以 在泛型为Integer的ArrayList中存放一个String 对象")
    void test5() {
        List<Integer> list = new ArrayList<>();
        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list, "Java反射机制实例");
        System.out.println(list.get(0));
    }

    @SneakyThrows
    @Test
    @DisplayName("通过反射可以 在泛型为Integer的ArrayList中存放一个String 对象")
    void test6() {
        List<Integer> list = new ArrayList<>();
        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list, "Java反射机制实例");
        System.out.println(list.get(0));
    }
}
//PECS 读取 生产者（Producer）使用 extends  上界
 class ProducerExample {
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4);
        List<Double> doubles = Lists.newArrayList(1.1, 2.2, 3.3);

        System.out.println("Sum of integers: " + sumOfList(integers));
        System.out.println("Sum of doubles: " + sumOfList(doubles));
    }
}
//PECS 放入 消费者（Consumer）使用 super  下界
class ConsumerExample {
    public static void addIntegersToList(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        addIntegersToList(numbers);

        List<Object> objects = new ArrayList<>();
        addIntegersToList(objects);

        System.out.println("Numbers: " + numbers);
        System.out.println("Objects: " + objects);
    }
}
