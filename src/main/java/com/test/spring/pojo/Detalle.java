/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.pojo;

/**
 *
 * @author hugo
 */
public class Detalle {
     public Integer id_detalleorden;
     public Integer id_orden;
     public Integer id_plato;
     public String cantidad;

    public Detalle() {
    }

    public Detalle(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId_detalleorden() {
        return id_detalleorden;
    }

    public void setId_detalleorden(Integer id_detalleorden) {
        this.id_detalleorden = id_detalleorden;
    }

    public Integer getId_orden() {
        return id_orden;
    }

    public void setId_orden(Integer id_orden) {
        this.id_orden = id_orden;
    }

    public Integer getId_plato() {
        return id_plato;
    }

    public void setId_plato(Integer id_plato) {
        this.id_plato = id_plato;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
     
     
     
}
