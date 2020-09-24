package com.example.mvccontinuation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Component
public class DecoupledLogicEnabler {
    private final SpringResourceTemplateResolver resolver;

    @Autowired
    public DecoupledLogicEnabler(SpringResourceTemplateResolver resolver) {
        this.resolver = resolver;
    }

    @PostConstruct
    public void init(){
        resolver.setUseDecoupledLogic(true);
    }

}
