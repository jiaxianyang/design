package com.example.design.singleton;

public class Mgr02 {

    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }
    private Mgr02() {
    }

    public static Mgr02 getInstance() {return INSTANCE;}

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr02 instance1 = Mgr02.getInstance();
        Mgr02 instance2 = Mgr02.getInstance();
        System.out.println(instance1 == instance2);
    }
}
