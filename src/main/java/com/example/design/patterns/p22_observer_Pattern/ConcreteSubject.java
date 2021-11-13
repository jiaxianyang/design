package com.example.design.patterns.p22_observer_Pattern;

public class ConcreteSubject extends Subject{

    public void doSomething() {
        /**
         * do something
         */
        super.notifyObservers();
    }
}
