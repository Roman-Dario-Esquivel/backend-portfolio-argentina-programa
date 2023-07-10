package com.portafolio.Roman_Dario_Esquivel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotNull
    private String nombreProyecto;
    @NotNull
    private String descripcionProyecto;
    @NotNull
    private String enlaceProyecto;

    private String imgProyecto;

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descripcionProyecto, String enlaceProyecto, String imgProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.enlaceProyecto = enlaceProyecto;
        this.imgProyecto = imgProyecto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getEnlaceProyecto() {
        return enlaceProyecto;
    }

    public void setEnlaceProyecto(String enlaceProyecto) {
        this.enlaceProyecto = enlaceProyecto;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }

}
