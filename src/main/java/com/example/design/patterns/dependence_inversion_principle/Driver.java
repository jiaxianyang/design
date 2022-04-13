package com.example.design.patterns.dependence_inversion_principle;

public class Driver implements IDriver{
    //司机的主要职责就是驾驶汽车
    public void drive(ICar car) {
        car.run();
    }
}
