package com.example.design.common.designs.chainOfResponsibility;

import java.util.Objects;

public abstract class BaseRequestHandler implements RequestHandler {

    protected RequestHandler next;

    public void next(RequestHandler next) {
        this.next = next;
    }

    @Override
    public void handler(String req) {
        doHandler(req);
        if (Objects.nonNull(next)) {
            next.handler(req);
        }
    }
}
