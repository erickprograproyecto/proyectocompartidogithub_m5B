/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Casas;
import java.util.ArrayList;
import java.util.List;


public interface CasasService {
    
    public Casas crear (Casas c); 
    
    public Casas findById(Integer id);

    public List<Casas> findByAll();

    public void delete(Integer id);
    
//   public Casas validarCasas(String codigo);
    public Casas getUser(Casas casas);
    
    public Casas BuscarCodigo(String codigo);
    

}
