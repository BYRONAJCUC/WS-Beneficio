/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.api.repository;

import com.beneficio.api.entity.Piloto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BYRON
 */
public interface PilotoRepository extends JpaRepository<Piloto, Long>{
    
    Optional<Piloto> findByUsuarioCreacion(String usuario);
    
    Optional<Piloto> findByLicencia(int licencia);
    
    boolean existsByLicencia(int licencia);
}
