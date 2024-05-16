package com.example.design.utils;

/**
 * @author jiaxianyang
 * @date 2024/5/6 10:34
 */
import com.example.design.common.entity.Person;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassFieldComparator {

    public static void compareFields(Class<?> class1, Class<?> class2) {
        Map<String, Class<?>> fieldsOfClass1 = new HashMap<>();
        Map<String, Class<?>> fieldsOfClass2 = new HashMap<>();

        // 将两个类的字段存储到Map中，键为字段名，值为字段类型
        for (Field field : class1.getDeclaredFields()) {
            fieldsOfClass1.put(field.getName(), field.getType());
        }
        for (Field field : class2.getDeclaredFields()) {
            fieldsOfClass2.put(field.getName(), field.getType());
        }

        List<String> commonFields = new ArrayList<>();
        List<String> uniqueToClass1 = new ArrayList<>();
        List<String> uniqueToClass2 = new ArrayList<>();
        List<String> typeMismatchFields = new ArrayList<>();

        // 寻找相同的字段、类1独有的字段以及类型不匹配的字段
        for (Map.Entry<String, Class<?>> entry : fieldsOfClass1.entrySet()) {
            if (fieldsOfClass2.containsKey(entry.getKey())) {
                if (fieldsOfClass2.get(entry.getKey()).equals(entry.getValue())) {
                    commonFields.add(entry.getKey() + " (" + entry.getValue().getSimpleName() + ")");
                } else {
                    typeMismatchFields.add(entry.getKey() + " (Class1: " + entry.getValue().getSimpleName() + ", Class2: " + fieldsOfClass2.get(entry.getKey()).getSimpleName() + ")");
                }
            } else {
                uniqueToClass1.add(entry.getKey() + " (" + entry.getValue().getSimpleName() + ")");
            }
        }

        // 寻找类2独有的字段
        for (Map.Entry<String, Class<?>> entry : fieldsOfClass2.entrySet()) {
            if (!fieldsOfClass1.containsKey(entry.getKey())) {
                uniqueToClass2.add(entry.getKey() + " (" + entry.getValue().getSimpleName() + ")");
            }
        }

        // 打印结果
//        System.out.println("Common Fields: " + commonFields);
        System.out.println("Unique to Class1: " + uniqueToClass1);
        System.out.println("Unique to Class2: " + uniqueToClass2);
        System.out.println("Type Mismatch Fields: " + typeMismatchFields);
    }

    public static void main(String[] args) {
        // 示例使用

        System.out.println("订单主档： ");
        compareFields(Person.class, Person.class);
        System.out.println("明细主档： ");
        compareFields(Person.class, Person.class);
    }
}

