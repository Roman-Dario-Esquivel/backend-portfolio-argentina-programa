package com.portafolio.Roman_Dario_Esquivel.Security.Repository;

import com.portafolio.Roman_Dario_Esquivel.Security.Entity.usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


   @Repository
public interface IUsuarioRepository extends JpaRepository<usuario, Integer>{
    Optional<usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario (String nombreUsuario);
    
    boolean existsByEmail(String email); 
}
