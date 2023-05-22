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
            private Date fechaHora;
            private String nombre_plato;

    public Orden(Date fechaHora, String nombre_plato)
    {
        this.fechaHora = fechaHora;
        this.nombre_plato = nombre_plato;
    }

    public Orden(Integer idOrden, Date fechaHora, String nombre_plato) {
        this.idOrden = idOrden;
        this.fechaHora = fechaHora;
        this.nombre_plato = nombre_plato;
    }
    
    

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

       
                    
    
}
