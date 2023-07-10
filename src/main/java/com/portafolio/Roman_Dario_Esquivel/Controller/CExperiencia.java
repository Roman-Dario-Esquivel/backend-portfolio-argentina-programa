package com.portafolio.Roman_Dario_Esquivel.Controller;

import org.apache.commons.lang3.StringUtils;
import com.portafolio.Roman_Dario_Esquivel.Dto.dtoExperiencia;
import com.portafolio.Roman_Dario_Esquivel.Entity.Experiencia;
import com.portafolio.Roman_Dario_Esquivel.Security.Controller.Mensaje;
import com.portafolio.Roman_Dario_Esquivel.Service.SExperiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = {"http://localhost:4200","https://romandarioesquivel.web.app"})
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){      
        if(StringUtils.isBlank(dtoexp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sExperiencia.existsByEmpresa(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
       
        Experiencia experiencia = new Experiencia( 
                dtoexp.getEmpresa(),
                dtoexp.getPuesto(),
                dtoexp.getDescripcion(),
                dtoexp.getLogo(),
                java.sql.Date.valueOf(dtoexp.getFecha_inicio()),
                Integer.valueOf(dtoexp.getActualmente()),
                java.sql.Date.valueOf(dtoexp.getFecha_fin()));
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        //Validamos si existe el ID
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sExperiencia.existsByEmpresa(dtoexp.getEmpresa()) && sExperiencia.getByEmpresa(dtoexp.getEmpresa()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        } else {
        }
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setEmpresa(dtoexp.getEmpresa());
        experiencia.setPuesto(dtoexp.getPuesto());
        experiencia.setDescripcion((dtoexp.getDescripcion()));
        experiencia.setLogo(dtoexp.getLogo());
        experiencia.setFecha_inicio(java.sql.Date.valueOf(dtoexp.getFecha_inicio()));
        experiencia.setActualmente(Integer.valueOf(dtoexp.getActualmente()));
        experiencia.setFecha_fin(java.sql.Date.valueOf(dtoexp.getFecha_fin()));
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}
