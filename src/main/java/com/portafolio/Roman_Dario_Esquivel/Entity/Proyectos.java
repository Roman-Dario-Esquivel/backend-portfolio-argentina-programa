package com.portafolio.Roman_Dario_Esquivel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotNull
    private String nombreProyectos;
    @NotNull
    private String DescripcionProyectos;
    @NotNull
    private String EnlaceProyecto;
    
    private String ImgProyecto;
    
    //Constructor

    public Proyectos() {
    }


    public Proyectos(String nombreProyectos, String DescripcionProyectos, String EnlaceProyecto, String ImgProyecto) {
        this.nombreProyectos = nombreProyectos;
        this.DescripcionProyectos = DescripcionProyectos;
        this.EnlaceProyecto = EnlaceProyecto;
        this.ImgProyecto = ImgProyecto;
    }
    
     // Getter and Setter 

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getnombreProyectos() {
        return nombreProyectos;
    }

    public void setNombre_titulacion(String nombreProyectos) {
        this.nombreProyectos = nombreProyectos;
    }

    public String getDescripcionProyectos() {
        return DescripcionProyectos;
    }

    public void setDescripcionProyectos(String DescripcionProyectos) {
        this.DescripcionProyectos = DescripcionProyectos;
    }

    public String getEnlaceProyecto() {
        return EnlaceProyecto;
    }

    public void setEnlaceProyecto(String EnlaceProyecto) {
        this.EnlaceProyecto = EnlaceProyecto;
    }

    public String getImgProyecto() {
        return ImgProyecto;
    }

    public void setImgProyecto(String ImgProyecto) {
        this.ImgProyecto = ImgProyecto;
    }

 
    
    
    
}
