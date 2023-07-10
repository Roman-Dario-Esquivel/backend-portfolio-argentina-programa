package com.portafolio.Roman_Dario_Esquivel.Dto;

import javax.validation.constraints.NotBlank;







public class ProyectoDto {
    
    @NotBlank
    private String nombreProyectos;
    @NotBlank
    private String DescripcionProyectos;
    @NotBlank
    private String EnlaceProyecto;
    @NotBlank
    private String ImgProyecto;

    public ProyectoDto() {
    }

    public ProyectoDto(String nombreProyectos, String DescripcionProyectos, String EnlaceProyecto, String ImgProyecto) {
        this.nombreProyectos = nombreProyectos;
        this.DescripcionProyectos = DescripcionProyectos;
        this.EnlaceProyecto = EnlaceProyecto;
        this.ImgProyecto = ImgProyecto;
    }

    public String getNombreProyectos() {
        return nombreProyectos;
    }

    public void setNombreProyectos(String nombreProyectos) {
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
