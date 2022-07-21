/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Gps;
import com.example.demo.service.GpsService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/gps")
public class GpsController {
    
    @Autowired
    GpsService gpsService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Gps>> listar(){
        return new ResponseEntity<>(gpsService.findByAll(),HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Gps> buscar(@PathVariable Integer id){
        
        return new ResponseEntity<>(gpsService.findById(id),HttpStatus.OK);
    }
    
   @GetMapping("/busca/{imei}")
    public Gps buscarCode1(@PathVariable String imei){
        Gps gps = new Gps();
        gps = gpsService.BuscarCodigo1(imei);
        
 
       
        return gps;
    
       
    }
    
     @PostMapping("/crear")
    public ResponseEntity<Gps> crear(@RequestBody Gps g){
        return new ResponseEntity<>(gpsService.crear(g),HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Gps>eliminar(@PathVariable Integer id){
        gpsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
        @PutMapping("/actualizar/{id}")
    public ResponseEntity<Gps> actualizar(@PathVariable Integer id, @RequestBody Gps g) {
        Gps gps = gpsService.findById(id);
        if (gps == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                gps.setEquipo(g.getEquipo());
                gps.setImei(g.getImei());
                gps.setNumeroChip(g.getNumeroChip());
                gps.setSerie(g.getSerie());
                gps.setCosto(g.getCosto());
                gps.setObservacion(g.getObservacion());
                
                return new ResponseEntity<>(gpsService.crear(g), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}
