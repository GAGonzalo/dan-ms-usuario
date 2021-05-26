package com.gga.danmsusuario.repository;

import com.gga.danmsusuario.model.Cliente;

import org.springframework.stereotype.Repository;

import frsf.isi.dan.InMemoryRepository;

@Repository
public class ClienteRepository extends InMemoryRepository<Cliente> {

    @Override
    public Integer getId(Cliente arg0) {
        return arg0.getId();
    }

    @Override
    public void setId(Cliente arg0, Integer arg1) {
        arg0.setId(arg1);
    }
    
   
}
