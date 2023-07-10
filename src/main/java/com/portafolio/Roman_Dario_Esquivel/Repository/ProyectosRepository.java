package com.portafolio.Roman_Dario_Esquivel.Repository;

import com.portafolio.Roman_Dario_Esquivel.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ProyectosRepository extends JpaRepository<Proyectos, Integer>{    
    public Optional<Proyectos> findBynombreProyectos(String nombreProyectos);
    public boolean existsBynombreProyectos(String nombreProyectos);
}
