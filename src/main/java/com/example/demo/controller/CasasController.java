/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Casas;
import com.example.demo.service.CasasService;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/casas")
public class CasasController {
    @Autowired
    CasasService casasservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Casas>> listar(){
         List<Casas> lista= casasservice.findByAll(); 
         List<Casas> nuevalista = new ArrayList<>();
         for (Casas casas: lista){
             double costoTotal = casas.getArea()*80; 
             casas.setCostoTotal(costoTotal);
             nuevalista.add(casas);
         }
         return new ResponseEntity<>(nuevalista,HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Casas> crear(@RequestBody Casas c){
        return new ResponseEntity<>(casasservice.crear(c),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Casas> eliminar(@PathVariable Integer id){
        casasservice.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Casas> buscar(@PathVariable Integer id){
        
        return new ResponseEntity<>(casasservice.findById(id),HttpStatus.OK);
    }
     


      public Casas buscarcasas(Integer id){
        return casasservice.findById(id);
    }
      
      
    @GetMapping("/busca/{codigo}")
    public Casas buscarCode(@PathVariable String codigo){
        Casas casas = new Casas();
        casas = casasservice.BuscarCodigo(codigo);
        
        double costototal = casas.getArea() * 80;
        casas.setCostoTotal(costototal);
        
       
        return casasservice.BuscarCodigo(codigo);
       
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Casas> actualizar(@PathVariable Integer id, @RequestBody Casas c){
        Casas casas = buscarcasas(id); 
        if (casas == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            casas.setArea(c.getArea());
            casas.setPropietario(c.getPropietario());
            casas.setTipoTerreno(c.getTipoTerreno());
            casas.setCodigo(c.getCodigo()); 
            casas.setCostoTotal(c.getCostoTotal());
          
            return new ResponseEntity<>(casasservice.crear(c),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    
    
    
}
