package com.portafolio.Roman_Dario_Esquivel.Service;


import com.portafolio.Roman_Dario_Esquivel.Entity.Experiencia;
import com.portafolio.Roman_Dario_Esquivel.Repository.RExperiencia;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
     @Autowired
     RExperiencia rExperiencia;
     
     public List<Experiencia> list(){
         return rExperiencia.findAll();
     }
     
     public Optional<Experiencia> getOne(int id){
         return rExperiencia.findById(id);
     }
     
     public Optional<Experiencia> getByEmpresa(String Empresa){
         return rExperiencia.findByEmpresa(Empresa);
     }
     
     public void save(Experiencia expe){
         rExperiencia.save(expe);
     }
     
     public void delete(int id){
         rExperiencia.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rExperiencia.existsById(id);
     }
     
     public boolean existsByEmpresa(String Empresa){
         return rExperiencia.existsByEmpresa(Empresa);
     }
}