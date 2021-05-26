package com.gga.danmsusuario.service;

import com.gga.danmsusuario.model.Usuario;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    public Boolean checkInformacion(Usuario u);
}
