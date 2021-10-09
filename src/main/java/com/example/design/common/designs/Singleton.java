package com.example.design.common.designs;

public class Singleton {
    static Singleton instance;

    static Singleton getSingleton() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
