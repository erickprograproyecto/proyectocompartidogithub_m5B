/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Zapatos;
import com.example.demo.repository.PantalonesRepository;
import com.example.demo.repository.ZapatosRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ZapatosServicelmpl implements ZapatosService {
    @Autowired
    private ZapatosRepository zapatosrepository;
    
     private final EntityManager entityManager;
    
    @Autowired
    public ZapatosServicelmpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
   

    @Override
    public Zapatos crear(Zapatos z) {
        return zapatosrepository.save(z);
    }

    @Override
    public Zapatos findById(Integer id) {
        return zapatosrepository.findById(id).orElse(null);
    }

    @Override
    public List<Zapatos> findByAll() {
        return zapatosrepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        zapatosrepository.deleteById(id);
    }

    @Override
    public Zapatos getUser(Zapatos zapatos) {
          TypedQuery<Zapatos> typedQuery = entityManager.createQuery(
                "SELECT z FROM zapatos z WHERE z.codigo = :codigo", Zapatos.class);
        try {
            Zapatos user = typedQuery.setParameter("codigo", zapatos.getCodigo()).getSingleResult();
            return user;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Zapatos BuscarCodigo3(String codigo) {
        return zapatosrepository.BuscarCodigo3(codigo);
    }
    
 
    
}
