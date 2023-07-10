package com.portafolio.Roman_Dario_Esquivel.Entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;





@Entity

public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String institucion;
    @NotNull
    private String titulacion;
    @NotNull
    private String descripcion_edu;
    private String logoimg;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int actualmente;
    //constructores

    public Educacion() {
    }

    public Educacion(String institucion, String titulacion, String descripcion_edu, String logoimg, Date fecha_inicio, Date fecha_fin, int actualmente) {
        this.institucion = institucion;
        this.titulacion = titulacion;
        this.descripcion_edu = descripcion_edu;
        this.logoimg = logoimg;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.actualmente = actualmente;
    }

    //setters and  getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    

    public String getDescripcion_edu() {
        return descripcion_edu;
    }

    public void setDescripcion_edu(String descripcion_edu) {
        this.descripcion_edu = descripcion_edu;
    }

    public String getLogoimg() {
        return logoimg;
    }

    public void setLogoimg(String logoimg) {
        this.logoimg = logoimg;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getActualmente() {
        return actualmente;
    }

    public void setActualmente(int actualmente) {
        this.actualmente = actualmente;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

}
