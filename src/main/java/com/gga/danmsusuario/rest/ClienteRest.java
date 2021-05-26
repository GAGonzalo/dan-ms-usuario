package com.gga.danmsusuario.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.gga.danmsusuario.model.Cliente;
import com.gga.danmsusuario.service.ClienteService;
import com.gga.danmsusuario.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/cliente")
@Api(value = "ClienteRest", description = "Permite gestionar los clientes de la empresa")
public class ClienteRest {
    
    @Autowired private ClienteService clienteService;
    
    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un cliente por id")
    public ResponseEntity<Cliente> clientePorId(@PathVariable Integer id){

        Cliente c = clienteService.buscarClientePorId(id);

        return ResponseEntity.ok(c);
    }

    @GetMapping
    @ApiOperation(value = "Busca la lista completa de los clientes")
    public ResponseEntity<List<Cliente>> todos(){
        ArrayList<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    @ApiOperation(value = "Crea un nuevo cliente")
    public ResponseEntity<String> crear(@RequestBody Cliente nuevo){
        
        Cliente c = clienteService.guardarCliente(nuevo);

        if(c==null){
            return ResponseEntity.badRequest().body("Informacion de obras/clientes incorrectas");
        }
        else return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado");

    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza un cliente")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente nuevo,  @PathVariable Integer id){
        nuevo.setId(id);
        Cliente modificado = clienteService.guardarCliente(nuevo);

        if(modificado== null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(modificado);
        }
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Borra a un cliente por id")
    public ResponseEntity<Cliente> borrar(@PathVariable Integer id){
       clienteService.bajaCliente(id);
       return ResponseEntity.ok().build();
    }

    @GetMapping(path="/")
    @ApiOperation(value = "Busca un cliente por CUIT o Razon Social")
    public ResponseEntity<Cliente> buscarPorCuitORazonSocial(@RequestParam(required=true) String cuit, @RequestParam(required=false) String rs){
       Cliente c = clienteService.buscarClienteCuitORazonSocial(cuit, rs);
       if(c==(null)){
           return ResponseEntity.notFound().build();
       }
       else return ResponseEntity.ok(c);
    }

}
