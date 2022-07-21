/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Gps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface GpsRepository extends JpaRepository<Gps, Integer>{
    
        @Query(value= "Select * from gps g where g.imei =:imei", nativeQuery= true)
    public Gps BuscarCodigo1(String imei);
    
}
