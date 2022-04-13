package com.example.design.patterns.dependence_inversion_principle;

public class Client {

    public static void main(String[] args) {
        IDriver zhangSan = new Driver();
        ICar benz = new BMW();
        zhangSan.drive(benz);
    }
}
