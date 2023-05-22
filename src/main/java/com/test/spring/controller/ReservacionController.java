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
    private Date fecha_hora;
    private String nombre_cliente;
    private String duracion;

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

//    public void guardaCategoria() {
//        SpringRestConsumer restConsumer = new SpringRestConsumer();
//        Categoria categoria = new Categoria(this.nombre);
//        restConsumer.guardaCategoria(categoria);
//        lstcatego = restConsumer.consumirApicategoria();
//    }
public void guardar() {
    SpringRestConsumer restConsumer = new SpringRestConsumer();
    
    // Verificar si hay un ID eliminado disponible
    Integer idDisponible = encontrarIdDisponible();
    if (idDisponible != null) {
        reservacion rese = new reservacion(this.nombre_cliente,this.duracion, this.fecha_hora );
        restConsumer.guardarreserva(rese);
    } else {
        reservacion rese = new reservacion(this.duracion, this.nombre_cliente, this.fecha_hora);
        restConsumer.guardarreserva(rese);
    }
    
    lstreser= restConsumer.consumereserva();
}

private Integer encontrarIdDisponible() {
    Integer idDisponible = null;
    
    // Verificar si hay un ID eliminado en la lista de categorías
    for (reservacion rese : lstreser) {
        if (rese.getId_reservacion()== null) {
            idDisponible = rese.getId_reservacion();
            break;
        }
    }
    
    return idDisponible;
}

    
    
}
