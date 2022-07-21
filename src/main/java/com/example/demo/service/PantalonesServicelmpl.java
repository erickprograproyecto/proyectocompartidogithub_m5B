/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Pantalones;
import com.example.demo.repository.PantalonesRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PantalonesServicelmpl implements PantalonesService{
    @Autowired
    private PantalonesRepository pantalonesrepository;
    
      private final EntityManager entityManager;
    
    @Autowired
    public PantalonesServicelmpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    

    @Override
    public Pantalones crear(Pantalones p) {
        return pantalonesrepository.save(p);
    }

    @Override
    public Pantalones findById(Integer id) {
        return pantalonesrepository.findById(id).orElse(null);
    }

    @Override
    public List<Pantalones> findByAll() {
        return pantalonesrepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        pantalonesrepository.deleteById(id);
    }

    @Override
    public Pantalones getUser(Pantalones pantalones) {
         TypedQuery<Pantalones> typedQuery = entityManager.createQuery(
                "SELECT p FROM pantalones p WHERE p.codigo = :codigo", Pantalones.class);
        try {
            Pantalones user = typedQuery.setParameter("codigo", pantalones.getCodigo()).getSingleResult();
            return user;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Pantalones BuscarCodigo2(String codigo) {
        return pantalonesrepository.BuscarCodigo2(codigo);
    }
    
    


}
