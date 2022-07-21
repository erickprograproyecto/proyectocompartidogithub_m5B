/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Pantalones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PantalonesRepository extends JpaRepository<Pantalones, Integer>{
    
    @Query(value= "Select * from pantalones p where p.codigo =:codigo", nativeQuery= true)
    public Pantalones BuscarCodigo2(String codigo);
}
