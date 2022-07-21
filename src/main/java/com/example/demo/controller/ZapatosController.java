/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;


import com.example.demo.model.Zapatos;
import com.example.demo.service.ZapatosService;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/zapatos")
public class ZapatosController {
      @Autowired
    ZapatosService zapatosservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Zapatos>> listar(){
         List<Zapatos> lista= zapatosservice.findByAll(); 
         List<Zapatos> nuevalista = new ArrayList<>();
         for (Zapatos zapatos: lista){
             double costoTotal = zapatos.getCantidad()* zapatos.getCosto(); 
             zapatos.setCostoTotalZ(costoTotal);
             nuevalista.add(zapatos);
         }
         return new ResponseEntity<>(nuevalista,HttpStatus.OK);
    }
    
      @PostMapping("/crear")
    public ResponseEntity<Zapatos> crear(@RequestBody Zapatos z){
        return new ResponseEntity<>(zapatosservice.crear(z),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Zapatos> eliminar(@PathVariable Integer id){
        zapatosservice.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Zapatos> buscar(@PathVariable Integer id){
        return new ResponseEntity<>(zapatosservice.findById(id),HttpStatus.OK);
    }
     


      public Zapatos buscarzapato(Integer id){
        return zapatosservice.findById(id);
    }
      
         @GetMapping("/busca/{codigo}")
    public Zapatos buscarCode(@PathVariable String codigo){
        Zapatos zapatos = new Zapatos();
        zapatos = zapatosservice.BuscarCodigo3(codigo);
        
        double costototal = zapatos.getCantidad() * zapatos.getCosto();
        zapatos.setCostoTotalZ(costototal);
        
       
        return zapatosservice.BuscarCodigo3(codigo);
       
    }
    

    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Zapatos> actualizar(@PathVariable Integer id, @RequestBody Zapatos z){
        Zapatos zapatos = buscarzapato(id); 
        if (zapatos == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            zapatos.setCantidad(z.getCantidad());
            zapatos.setCodigo(z.getCodigo());
            zapatos.setCosto(z.getCosto());
            zapatos.setMarca(z.getMarca()); 
            zapatos.setTipoDeZapatos(z.getTipoDeZapatos());
          
            return new ResponseEntity<>(zapatosservice.crear(z),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
