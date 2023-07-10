package com.portafolio.Roman_Dario_Esquivel.Dto;


import javax.validation.constraints.NotBlank;


public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imgperfil;
    @NotBlank
    private String imgbanner;

    public dtoPersona(String nombre, String apellido, String descripcion, String imgperfil, String imgbanner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.imgperfil = imgperfil;
        this.imgbanner = imgbanner;
    }

    public dtoPersona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgperfil() {
        return imgperfil;
    }

    public void setImgperfil(String imgperfil) {
        this.imgperfil = imgperfil;
    }

    public String getImgbanner() {
        return imgbanner;
    }

    public void setImg_banner(String img_banner) {
        this.imgbanner = imgbanner;
    }

    
   
    
    
}
