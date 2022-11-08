package com.portfolio.Roman_Dario_Esquivel.Repository;

import com.portfolio.Roman_Dario_Esquivel.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    
}
    