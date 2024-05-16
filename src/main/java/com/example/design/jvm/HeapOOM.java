package com.example.design.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxianyang
 * @date 2024/4/16 15:17
 */
public class HeapOOM {
    /**
     * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     *
     * @author zzm
     */
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
