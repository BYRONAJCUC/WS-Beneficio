/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.service;

import com.beneficio.api.entity.Piloto;
import com.beneficio.api.repository.PilotoRepository;
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
public class PilotoService {
    
    @Autowired
    PilotoRepository pilotoRepository;
    
    public List<Piloto> list(){
        return pilotoRepository.findAll();
    }

    public Optional<Piloto> getOne(Long id){
        return pilotoRepository.findById(id);
    }

    public Optional<Piloto> getByUsuarioCreacion(String usuario){
        return pilotoRepository.findByUsuarioCreacion(usuario);
    }

    public void  save(Piloto piloto){
        pilotoRepository.save(piloto);
    }

    public void delete(Long id){
        pilotoRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return pilotoRepository.existsById(id);
    }

    public boolean existsByLicencia(int licencia){
        return pilotoRepository.existsByLicencia(licencia);
    }
}
