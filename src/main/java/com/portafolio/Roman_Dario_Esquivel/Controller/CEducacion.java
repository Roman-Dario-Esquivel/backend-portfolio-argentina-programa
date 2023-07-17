package com.portafolio.Roman_Dario_Esquivel.Controller;



import org.apache.commons.lang3.StringUtils;
import com.portafolio.Roman_Dario_Esquivel.Dto.dtoEducacion;
import com.portafolio.Roman_Dario_Esquivel.Entity.Educacion;
import com.portafolio.Roman_Dario_Esquivel.Security.Controller.Mensaje;
import com.portafolio.Roman_Dario_Esquivel.Service.SEducacion;
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
@RequestMapping("/educacion")
//@Api(value = "Portafolio", description = "api de educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"https://romandarioesquivel-9162f.web.app/","https://romandarioesquivel-9162f.firebaseapp.com/"})
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    //@ApiOperation(value = "devuelve lista de personas")
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getTitulacion())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByTitulacion(dtoeducacion.getTitulacion())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
                dtoeducacion.getInstitucion(),
                dtoeducacion.getTitulacion(),
                dtoeducacion.getDescripcion_edu(),
                dtoeducacion.getLogoimg(),
                java.sql.Date.valueOf(dtoeducacion.getFecha_inicio()),
                java.sql.Date.valueOf(dtoeducacion.getFecha_fin()),
                Integer.valueOf(dtoeducacion.getActualmente())
            );
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByTitulacion(dtoeducacion.getTitulacion()) && sEducacion.getByTitulacion(dtoeducacion.getTitulacion()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getTitulacion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setTitulacion(dtoeducacion.getTitulacion());
        educacion.setInstitucion(dtoeducacion.getInstitucion());
        educacion.setDescripcion_edu(dtoeducacion.getDescripcion_edu());
        educacion.setLogoimg(dtoeducacion.getLogoimg());
        educacion.setFecha_inicio(java.sql.Date.valueOf(dtoeducacion.getFecha_inicio()));
        educacion.setFecha_fin(java.sql.Date.valueOf(dtoeducacion.getFecha_fin()));
        educacion.setActualmente(Integer.valueOf(dtoeducacion.getActualmente()));
        
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
