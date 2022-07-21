/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Gps;
import com.example.demo.repository.GpsRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;




@Service
public class GpsServicelmpl implements GpsService{
    
    @Autowired
    GpsRepository gpsrepository;
    
      private final EntityManager entityManager;
    
    @Autowired
    public GpsServicelmpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    
    @Override
    public Gps crear(Gps g) {
        return gpsrepository.save(g);
    }

    @Override
    public Gps findById(Integer id) {
        return gpsrepository.findById(id).orElse(new Gps());
    }

    @Override
    public List<Gps> findByAll() {
        return gpsrepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        gpsrepository.deleteById(id);
    }

    @Override
    public Gps getUser(Gps gps) {

        TypedQuery<Gps> typedQuery = entityManager.createQuery(
                "SELECT g FROM gps g WHERE g.imei = :imei", Gps.class);
        try {
            Gps user = typedQuery.setParameter("imei", gps.getImei()).getSingleResult();
            return user;

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Gps BuscarCodigo1(String imei) {

        return gpsrepository.BuscarCodigo1(imei);

    }

  

    
}
