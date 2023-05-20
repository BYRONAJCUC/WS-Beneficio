/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.service;

import com.beneficio.api.entity.Cuenta;
import com.beneficio.api.repository.CuentaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BYRON
 */

@Service
@Transactional
public class CuentaService {
    
    @Autowired
    CuentaRepository cuentaRepository;
    
    public List<Cuenta> list(){
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> getOne(int id){
        return cuentaRepository.findById(id);
    }

    public Optional<Cuenta> getByUsuarioCreacion(String usuario){
        return cuentaRepository.findByUsuarioCreacion(usuario);
    }

    public void  save(Cuenta cuenta){
        cuentaRepository.save(cuenta);
    }

    public void delete(int id){
        cuentaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return cuentaRepository.existsById(id);
    }
}
