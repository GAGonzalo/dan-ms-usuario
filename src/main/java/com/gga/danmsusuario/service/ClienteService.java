package com.gga.danmsusuario.service;

import java.util.ArrayList;

import com.gga.danmsusuario.model.Cliente;

import org.springframework.stereotype.Service;


@Service
public interface ClienteService {
    
    public Cliente guardarCliente(Cliente c);
    public void bajaCliente(Integer id);
    public Cliente buscarClientePorId(Integer id);
    public ArrayList<Cliente> getClientes();
    public Cliente buscarClienteCuitORazonSocial(String cuit, String razon);

}
