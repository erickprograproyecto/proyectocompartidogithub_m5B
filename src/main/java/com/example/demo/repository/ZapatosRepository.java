/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Zapatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ZapatosRepository extends JpaRepository<Zapatos, Integer>{
   @Query(value= "Select * from zapatos z where z.codigo =:codigo", nativeQuery= true)
    public Zapatos BuscarCodigo3(String codigo);
}
