package com.example.design.jvm;

/**
 * @author jiaxianyang
 * @date 2024/4/16 17:35
 */

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M (不适用)
 *
 * jdk8 之后 常量池移到堆内存中了  -Xms6m -Xmx6m
 *
 * @author zzm
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
