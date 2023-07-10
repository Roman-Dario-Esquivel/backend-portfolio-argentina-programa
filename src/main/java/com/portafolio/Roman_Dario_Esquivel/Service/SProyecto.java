package com.portafolio.Roman_Dario_Esquivel.Service;

import com.portafolio.Roman_Dario_Esquivel.Entity.Proyecto;
import com.portafolio.Roman_Dario_Esquivel.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    @Autowired 
    RProyecto proyecto;
    
    public List<Proyecto> list(){
         return proyecto.findAll();
     }
     
     public Optional<Proyecto> getOne(int id){
         return proyecto.findById(id);
     }
     
     public Optional<Proyecto> getByNombreProyecto(String nombreProyecto){
         return proyecto.findByNombreProyecto(nombreProyecto);
     }
     
     public void save(Proyecto proyec){
         proyecto.save(proyec);
     }
     
     public void delete(int id){
         proyecto.deleteById(id);
     }
     
     public boolean existsById(int id){
         return proyecto.existsById(id);
     }
     
     public boolean existsByNombreProyecto(String nombreProyecto){
         return proyecto.existsByNombreProyecto(nombreProyecto);
     }
}
