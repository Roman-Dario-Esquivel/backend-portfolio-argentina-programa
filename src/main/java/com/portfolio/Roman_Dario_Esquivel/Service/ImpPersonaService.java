package com.portfolio.Roman_Dario_Esquivel.Service; 
import com.portfolio.Roman_Dario_Esquivel.Entity.Persona;
import com.portfolio.Roman_Dario_Esquivel.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
    
  
     
     public List<Persona> list(){
         return ipersonaRepository.findAll();
     }
     
     public Optional<Persona> getOne(Long id){
         return ipersonaRepository.findById(id);
     }
     
     public Optional<Persona> getByNombre(String nombre){
         return ipersonaRepository.findByNombre(nombre);
     }
     
     public void save(Persona expe){
         ipersonaRepository.save(expe);
     }
     
     public void delete(Long id){
         ipersonaRepository.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return ipersonaRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return ipersonaRepository.existsByNombre(nombre);
     }
    
    
}