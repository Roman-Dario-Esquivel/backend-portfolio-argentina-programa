package com.portafolio.Roman_Dario_Esquivel.Dto;

import javax.validation.constraints.NotBlank;






public class dtoEducacion {
    @NotBlank
    private String institucion;
    @NotBlank
    private String titulacion;
    @NotBlank
    private String descripcion_edu;
    @NotBlank
    private String logoimg;
    @NotBlank
    private String fecha_inicio;
    private String actualmente;
    private String fecha_fin;

    //Constructor

    public dtoEducacion() {
    }

    public dtoEducacion(String institucion, String titulacion, String descripcion_edu, String logoimg, String fecha_inicio, String actualmente, String fecha_fin) {
        this.institucion = institucion;
        this.titulacion = titulacion;
        this.descripcion_edu = descripcion_edu;
        this.logoimg = logoimg;
        this.fecha_inicio = fecha_inicio;
        this.actualmente = actualmente;
        this.fecha_fin = fecha_fin;
    }    

    // Setters y getters

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
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

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getActualmente() {
        return actualmente;
    }

    public void setActualmente(String actualmente) {
        this.actualmente = actualmente;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    
    
    
}
