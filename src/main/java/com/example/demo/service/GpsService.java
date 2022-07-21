/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Gps;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GpsService{
    public Gps crear(Gps g);
    
    public Gps findById(Integer id); 
    
    public List<Gps> findByAll(); 
    
    public void delete(Integer id);
    
       public Gps getUser(Gps gps);
    
    public Gps BuscarCodigo1(String imei);
    

}
