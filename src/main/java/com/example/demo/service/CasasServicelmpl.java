/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Casas;
import com.example.demo.repository.CasasRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CasasServicelmpl implements CasasService{
    
    @Autowired
    private CasasRepository casasrepository;
    
    private final EntityManager entityManager;
    
    @Autowired
    public CasasServicelmpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    
    
    

    @Override
    public Casas crear(Casas c) {
        return casasrepository.save(c);
    }

    @Override
    public Casas findById(Integer id) {
        return casasrepository.findById(id).orElse(null);
    }

    @Override
    public List<Casas> findByAll() {
        return casasrepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        casasrepository.deleteById(id);
    }

    @Override
    public Casas getUser(Casas casas) {

        TypedQuery<Casas> typedQuery = entityManager.createQuery(
                "SELECT c FROM casas c WHERE c.codigo = :codigo", Casas.class);
        try {
            Casas user = typedQuery.setParameter("codigo", casas.getCodigo()).getSingleResult();
            return user;

        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public Casas BuscarCodigo(String codigo) {
        return casasrepository.BuscarCodigo(codigo);
           }

  
    
    
   
    
}
