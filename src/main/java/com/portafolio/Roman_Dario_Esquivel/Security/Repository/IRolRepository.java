package com.portafolio.Roman_Dario_Esquivel.Security.Repository;

import com.portafolio.Roman_Dario_Esquivel.Security.Entity.Rol;
import com.portafolio.Roman_Dario_Esquivel.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
     Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
