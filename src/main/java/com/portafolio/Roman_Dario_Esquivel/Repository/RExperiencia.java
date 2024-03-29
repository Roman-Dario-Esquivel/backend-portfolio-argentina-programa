package com.portafolio.Roman_Dario_Esquivel.Repository;

import com.portafolio.Roman_Dario_Esquivel.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByEmpresa(String Empresa);
    public boolean existsByEmpresa(String Empresa);
}
