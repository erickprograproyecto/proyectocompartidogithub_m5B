/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Pantalones;
import java.util.List;


public interface PantalonesService {
    public Pantalones crear (Pantalones p);
    
    public Pantalones findById(Integer id);
    
    public List<Pantalones> findByAll();
    
    public void delete(Integer id);
    
    public Pantalones getUser(Pantalones pantalones);
    
    public Pantalones BuscarCodigo2(String codigo);
     
}
