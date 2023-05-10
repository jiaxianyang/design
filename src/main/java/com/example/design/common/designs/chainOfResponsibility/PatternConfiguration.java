package com.example.design.common.designs.chainOfResponsibility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PatternConfiguration {

    @Bean
    public HandleChainManager handlerChainExecute(List<IHandler> handlers) {
        HandleChainManager handleChainManager = new HandleChainManager();
        handleChainManager.setHandleMap(handlers);
        return handleChainManager;
    }
}
