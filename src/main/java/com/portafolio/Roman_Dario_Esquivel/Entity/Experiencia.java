package com.portafolio.Roman_Dario_Esquivel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String empresa;
    @NotNull
    private String puesto;
    @NotNull
    private String descripcion;
    @NotNull
    private String logo;
    
    private Date fecha_inicio;
    
    private int actualmente;
    
    private Date fecha_fin;
    
    //Constructores
    public Experiencia() {
    }

    public Experiencia(String empresa, String puesto, String descripcion, String logo, Date fecha_inicio, int actualmente, Date fecha_fin) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.logo = logo;
        this.fecha_inicio = fecha_inicio;
        this.actualmente = actualmente;
        this.fecha_fin = fecha_fin;
    }

       //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String Empresa) {
        this.empresa = Empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getActualmente() {
        return actualmente;
    }

    public void setActualmente(int actualmente) {
        this.actualmente = actualmente;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    

    

   
}
