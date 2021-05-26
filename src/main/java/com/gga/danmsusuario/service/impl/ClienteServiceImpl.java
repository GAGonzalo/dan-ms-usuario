package com.gga.danmsusuario.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.gga.danmsusuario.model.Cliente;
import com.gga.danmsusuario.repository.ClienteRepository;
import com.gga.danmsusuario.service.ClienteService;
import com.gga.danmsusuario.service.RiesgoCrediticioService;
import com.gga.danmsusuario.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private RiesgoCrediticioService riesgoCrediticioService;
    @Autowired 
    private UsuarioService usuarioService;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente guardarCliente(Cliente c) {
        //CREAR
        if(c.getId() == null){
            System.out.println(c.toString());
            if(c.getObras()==null || c.getUsuario()==null){
                return null;
            }
            if(!(c.getObras().isEmpty()) && usuarioService.checkInformacion(c.getUsuario()) && riesgoCrediticioService.bcraPositivo(c.getCuit())){
                return clienteRepository.save(c);
            }
            else{
                return null;
            }
        }
        //UPDATE
        else{
                return clienteRepository.save(c);
            } 
    }


    @Override
    public void bajaCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente buscarClientePorId(Integer id) {
       return clienteRepository.findById(id).get();
    }

    @Override
    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        clienteRepository.findAll().forEach(listaClientes::add);

        return listaClientes;
    }

    @Override
    public Cliente buscarClienteCuitORazonSocial(String cuit, String razon) {
        Cliente c = null;

        Iterable<Cliente> listaClientesIterable = clienteRepository.findAll();

        if(razon == null){
            for(Cliente t : listaClientesIterable){
                if (t.getCuit().equals(cuit)){
                    c = t;
                    break;
                }
            }
        }
        else{
            for(Cliente t : listaClientesIterable){
                if (t.getCuit().equals(cuit) && t.getRazonSocial().equals(razon)){
                    c = t;
                    break;
                }
            }
        }
        return c;
    }


    public ClienteServiceImpl(RiesgoCrediticioService riesgoCrediticioService, UsuarioService usuarioService) {
        this.riesgoCrediticioService = riesgoCrediticioService;
        this.usuarioService = usuarioService;
    }

    
}
