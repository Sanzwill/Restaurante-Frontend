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
public class reservacion {
    private Integer id_reservacion;
    private Date fecha_hora;
    private String nombre_cliente;
    private String duracion;

    public reservacion(String nombre_cliente, String duracion, Date fecha_hora) {
        this.fecha_hora = fecha_hora;
        this.nombre_cliente = nombre_cliente;
        this.duracion = duracion;
    }

    public Integer getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(Integer id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

}
