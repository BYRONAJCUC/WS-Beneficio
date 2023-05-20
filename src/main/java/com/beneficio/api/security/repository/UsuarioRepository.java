package com.beneficio.api.security.repository;

import com.beneficio.api.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByDpi(int dpi);
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByDpi(Long dpi);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    
    boolean existsByEmail(String email);

}
