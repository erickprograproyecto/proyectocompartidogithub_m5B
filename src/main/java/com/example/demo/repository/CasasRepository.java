/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Casas;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CasasRepository extends JpaRepository<Casas, Integer>{
    
    @Query(value= "Select * from casas c where c.codigo =:codigo", nativeQuery= true)
    public Casas BuscarCodigo(String codigo);
    
//    ArrayList<Casas> findByCodigo(String codigo);
//    
//    Casas findCasasByCodigo(String codigo);
    
}
