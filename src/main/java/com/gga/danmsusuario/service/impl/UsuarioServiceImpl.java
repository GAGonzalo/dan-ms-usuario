package com.gga.danmsusuario.service.impl;

import com.gga.danmsusuario.model.Usuario;
import com.gga.danmsusuario.service.UsuarioService;

import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements UsuarioService{

    @Override
    public Boolean checkInformacion(Usuario u) {
        if (u==null){
            return false;
            
        }
        else{
            if(u.getUser()==null || u.getPassword()==null){
                return false;
            }
            else return true;
        } 
    }
    
}
