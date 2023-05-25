/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.reservacion;
import com.test.spring.service.SpringRestConsumer;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hugo
 */
@Named(value="reservaController")
@ViewScoped
public class ReservacionController implements Serializable{
     List <reservacion> lstreser =new ArrayList<>();
   private Integer id_reservacion;
    private String fecha_hora;
    private String nombre_cliente;
    private String duracion;
       private reservacion reserteEditando;
    private boolean modoEdicion;

    public List<reservacion> getLstreser() {
        return lstreser;
    }

    public void setLstreser(List<reservacion> lstreser) {
        this.lstreser = lstreser;
    }

    public Integer getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(Integer id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
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

    public reservacion getReserteEditando() {
        return reserteEditando;
    }

    public void setReserteEditando(reservacion reserteEditando) {
        this.reserteEditando = reserteEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

   
 public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstreser = restConsumer.consumereserva();
    }

    public void limpiar() {
        lstreser.clear();
    }

    public void borrar(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borrarreserva(id);
        lstreser= restConsumer.consumereserva();
    }

public void guardarCliente() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        reservacion reser = new reservacion(this.nombre_cliente, this.duracion,  this.fecha_hora);
        restConsumer.guardarreserva(reser);
        lstreser = restConsumer.consumereserva();
        this.setNombre_cliente("");
        this.setFecha_hora("");
        this.setDuracion("");
        
    }

    public void editar(Integer id_reservacion, String duracion, String nombre_cliente, String fecha_hora) {
        modoEdicion = true;
        this.setId_reservacion(id_reservacion);
        this.setDuracion(duracion);
        this.setNombre_cliente(nombre_cliente);
        this.setFecha_hora(fecha_hora);
       

    }

    public void ActualizarCliente() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizarreserva(this.getId_reservacion(), this.getDuracion(), this.getNombre_cliente(), this.getFecha_hora());
        this.callApi();
        this.setDuracion("");
        this.setFecha_hora("");
        this.setNombre_cliente("");
       
        modoEdicion = false;
    }

    
    
}
