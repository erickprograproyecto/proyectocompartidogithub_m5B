/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;


import com.example.demo.model.Pantalones;
import com.example.demo.service.PantalonesService;
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
@RequestMapping("/api/pantalones")
public class PantalonesController {
     @Autowired
    PantalonesService pantalonesservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Pantalones>> listar(){
         List<Pantalones> lista= pantalonesservice.findByAll(); 
         List<Pantalones> nuevalista = new ArrayList<>();
         for (Pantalones pantalones: lista){
             double costoTotal = pantalones.getCantidad()* pantalones.getCosto(); 
             pantalones.setCostoTotalP(costoTotal);
             nuevalista.add(pantalones);
         }
         return new ResponseEntity<>(nuevalista,HttpStatus.OK);
    }
    
      @PostMapping("/crear")
    public ResponseEntity<Pantalones> crear(@RequestBody Pantalones p){
        return new ResponseEntity<>(pantalonesservice.crear(p),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Pantalones> eliminar(@PathVariable Integer id){
        pantalonesservice.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pantalones> buscar(@PathVariable Integer id){
        return new ResponseEntity<>(pantalonesservice.findById(id),HttpStatus.OK);
    }
     


      public Pantalones buscarpantalones(Integer id){
        return pantalonesservice.findById(id);
    }
    
      @GetMapping("/busca/{codigo}")
    public Pantalones buscarCode(@PathVariable String codigo) {
        Pantalones pantalones = new Pantalones();
        pantalones = pantalonesservice.BuscarCodigo2(codigo);

        double costototal = pantalones.getCosto() * pantalones.getCantidad();
        pantalones.setCostoTotalP(costototal);

        return pantalonesservice.BuscarCodigo2(codigo);

    }

    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Pantalones> actualizar(@PathVariable Integer id, @RequestBody Pantalones p){
        Pantalones pantalones = buscarpantalones(id); 
        if (pantalones == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            pantalones.setCantidad(pantalones.getCantidad()); 
            pantalones.setCodigo(pantalones.getCodigo());
            pantalones.setCosto(pantalones.getCosto());
            pantalones.setFabricante(pantalones.getFabricante());
            pantalones.setMarca(pantalones.getMarca());
            pantalones.setModelo(pantalones.getModelo());
          
            return new ResponseEntity<>(pantalonesservice.crear(p),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
