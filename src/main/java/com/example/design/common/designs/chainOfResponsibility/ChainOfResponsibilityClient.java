package com.example.design.common.designs.chainOfResponsibility;

public class ChainOfResponsibilityClient {
    public static void main(String[] args) {
        AHandler a = new AHandler();
        BHandler b = new BHandler();
        CHandler c = new CHandler();
        a.next(b);
        b.next(c);
        a.handler("链路待处理的数据");
    }
}
