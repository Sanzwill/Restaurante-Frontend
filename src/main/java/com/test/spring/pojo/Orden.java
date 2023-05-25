/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.pojo;

import java.util.Date;

/**
 *
 * @author hugo
 */
public class Orden {
    private Integer idOrden;
            private String fechaHora;
            private String nombre_plato;

    public Orden(String fechaHora, String nombre_plato) {
        this.fechaHora = fechaHora;
        this.nombre_plato = nombre_plato;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }
    

}
