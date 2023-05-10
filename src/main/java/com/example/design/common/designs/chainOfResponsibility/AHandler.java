package com.example.design.common.designs.chainOfResponsibility;

public class AHandler extends BaseRequestHandler{
    @Override
    public void doHandler(String req) {
        //处理自己的逻辑
        System.out.println("A中处理自己的逻辑");
        //传递给下一个类（若链中还有下一个处理类）
//        if (next != null) {
//            next.doHandler(req);
//        }
    }
}
