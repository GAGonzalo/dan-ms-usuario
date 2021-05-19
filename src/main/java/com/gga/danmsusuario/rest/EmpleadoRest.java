package com.gga.danmsusuario.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.gga.danmsusuario.model.Empleado;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/empleado")
@Api(value = "EmpleadoRest", description = "Permite gestionar los empleados de la empresa")
public class EmpleadoRest {

    private final List<Empleado> listaEmpleados = new ArrayList<>();
    private static Integer ID = 1;
    @GetMapping(path="/{id}")
    @ApiOperation(value = "Busca un empleado por id")
    public ResponseEntity<Empleado> buscarPorId(@PathVariable Integer id){
        Optional<Empleado> e ;
        e= listaEmpleados.stream().filter(empleado-> empleado.getId()==id).findFirst();
        return ResponseEntity.of(e);
    }

    @GetMapping(path="/nombre/{nombre}")
    @ApiOperation(value = "Busca un empleado por su nombre")
    public ResponseEntity<Empleado> buscarPorNombre(@PathVariable(required = false) String nombre){
        Optional<Empleado> e= listaEmpleados.stream().filter(empleado->empleado.getUsuario().getUser().equals(nombre)).findFirst();
        System.out.println(listaEmpleados);
        System.out.println(nombre);
        
        return ResponseEntity.of(e);
    }
    
    @PostMapping
    @ApiOperation(value = "Crea un empleado")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){
        empleado.setId(ID++);
        listaEmpleados.add(empleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Borra un empleado por id")
    public ResponseEntity<Empleado> borrar(@PathVariable Integer id){
        OptionalInt indexOpt  =   IntStream.range(0, listaEmpleados.size())
        .filter(i -> listaEmpleados.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            listaEmpleados.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.ok().build();

        }
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza un empleado")
    public ResponseEntity<Empleado> actualizar(@RequestBody Empleado e, @PathVariable Integer id){
        OptionalInt indexOpt =   IntStream.range(0, listaEmpleados.size())
        .filter(i -> listaEmpleados.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            listaEmpleados.set(indexOpt.getAsInt(), e);
            return ResponseEntity.ok(e);
        } else {    
            return ResponseEntity.notFound().build();
        }
    }


}
