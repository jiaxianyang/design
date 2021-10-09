package com.example.design.common.designs;

public class VolatileExample {
    
    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            //这里的x会是什么值呢
        }
    }
}
