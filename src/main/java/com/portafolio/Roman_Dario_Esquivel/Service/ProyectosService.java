package com.portafolio.Roman_Dario_Esquivel.Service;

import com.portafolio.Roman_Dario_Esquivel.Entity.Proyectos;
import com.portafolio.Roman_Dario_Esquivel.Repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
    @Autowired 
    ProyectosRepository proyecto;
    
    public List<Proyectos> list(){
         return proyecto.findAll();
     }
     
     public Optional<Proyectos> getOne(int id){
         return proyecto.findById(id);
     }
     
     public Optional<Proyectos> getBynombreProyectos(String nombreProyectos){
         return proyecto.findBynombreProyectos(nombreProyectos);
     }
     
     public void save(Proyectos expe){
         proyecto.save(expe);
     }
     
     public void delete(int id){
         proyecto.deleteById(id);
     }
     
     public boolean existsById(int id){
         return proyecto.existsById(id);
     }
     
     public boolean existsBynombreProyectos(String nombreProyectos){
         return proyecto.existsBynombreProyectos(nombreProyectos);
     }
}
