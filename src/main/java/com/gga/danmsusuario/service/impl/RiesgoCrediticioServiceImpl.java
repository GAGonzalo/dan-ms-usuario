package com.gga.danmsusuario.service.impl;

import com.gga.danmsusuario.service.RiesgoCrediticioService;

import org.springframework.stereotype.Component;

@Component
public class RiesgoCrediticioServiceImpl implements RiesgoCrediticioService{

    @Override
    public Boolean bcraPositivo(String cuit) {
        return true;
    }
    
}
