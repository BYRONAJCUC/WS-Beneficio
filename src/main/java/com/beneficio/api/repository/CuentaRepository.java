/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.api.repository;

import com.beneficio.api.entity.Cuenta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BYRON
 */
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
    
    Optional<Cuenta> findByUsuarioCreacion(String usuario);
    
    boolean existsById(int cuenta);
}
