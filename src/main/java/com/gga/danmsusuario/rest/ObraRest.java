package com.gga.danmsusuario.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.gga.danmsusuario.model.Cliente;
import com.gga.danmsusuario.model.Obra;
import com.gga.danmsusuario.model.TipoObra;

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
@RequestMapping("/api/obra")
@Api(value = "ObraRest", description = "Permite gestionar las obras")
public class ObraRest {
     private final List<Obra> listaObra = new ArrayList<>();
    private static Integer ID = 1;

    @GetMapping(path="/{id}")
    @ApiOperation(value = "Busca una obra por id")
    public ResponseEntity<Obra> buscarPorId(@PathVariable Integer id){
        Optional<Obra> obra ;
        obra= listaObra.stream().filter(o-> o.getId()==id).findFirst();
        return ResponseEntity.of(obra);
    }


    @GetMapping(path = "/cliente")
    @ApiOperation(value = "Busca una obra por cliente")
    public ResponseEntity<List<Obra>> buscarPorCliente(@RequestBody(required = false) Cliente cliente){

        List<Obra> result = new ArrayList();

        for(Obra o : listaObra){
            if (cliente!= null && o.getCliente().equals(cliente) ){
                    result.add(o);
            }
        }

        return ResponseEntity.ok(result);
    }

    
   @GetMapping(path = "/tipo")
   @ApiOperation(value = "Busca una obra por el tipo de obra")

    public ResponseEntity<List<Obra>> buscarPorTipoObra(@RequestBody(required = false) TipoObra tipoObra){

        List<Obra> result = new ArrayList();

        for(Obra o : listaObra){
            if (tipoObra!= null && o.getTipo().equals(tipoObra) ){
                    result.add(o);
            }
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "Crea una obra")
    public ResponseEntity<Obra> crearObra(@RequestBody Obra obra){
        obra.setId(ID++);
        listaObra.add(obra);
        return ResponseEntity.ok(obra);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Borra una obra por id")
    public ResponseEntity<Obra> borrar(@PathVariable Integer id){
        OptionalInt indexOpt  =   IntStream.range(0, listaObra.size())
        .filter(i -> listaObra.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            listaObra.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.ok().build();

        }
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza una obra")
    public ResponseEntity<Obra> actualizar(@RequestBody Obra o, @PathVariable Integer id){
        OptionalInt indexOpt =   IntStream.range(0, listaObra.size())
        .filter(i -> listaObra.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            listaObra.set(indexOpt.getAsInt(), o);
            return ResponseEntity.ok(o);
        } else {    
            return ResponseEntity.notFound().build();
        }
    }
}
