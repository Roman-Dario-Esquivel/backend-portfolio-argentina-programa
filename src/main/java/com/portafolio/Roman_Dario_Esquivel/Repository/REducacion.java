package com.portafolio.Roman_Dario_Esquivel.Repository;

import com.portafolio.Roman_Dario_Esquivel.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByTitulacion(String Titulacion);
    public boolean existsByTitulacion(String Titulacion);
}

