
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.Detalle;
import com.test.spring.service.SpringRestConsumer;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo
 */
@Named(value = "detalleController")
@ViewScoped
public class DetalleController implements Serializable {

    List<Detalle> lstDetalle = new ArrayList<>();
    private Integer id_detalleorden;
    private Integer id_orden;
    private Integer id_plato;
    private String cantidad;
    private Detalle deteEditando;
    private boolean modoEdicion;

    public List<Detalle> getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(List<Detalle> lstDetalle) {
        this.lstDetalle = lstDetalle;
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

    public Detalle getDeteEditando() {
        return deteEditando;
    }

    public void setDeteEditando(Detalle deteEditando) {
        this.deteEditando = deteEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstDetalle = restConsumer.consumeApiDetalle();
    }

    public void limpiar() {
        lstDetalle.clear();
    }

    public void eliminardetalle(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraApiCliente(id);
        lstDetalle = restConsumer.consumeApiDetalle();
    }

    public void guardardetalle() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Detalle detalle = new Detalle(this.cantidad);
        restConsumer.guardaApiDetalle(detalle);
        lstDetalle = restConsumer.consumeApiDetalle();
        this.setCantidad("");
    }

    public void editardetalle(Integer id_detalleorden, String cantidad){
        this.setId_detalleorden(id_detalleorden);
        this.setCantidad(cantidad);
        

    }

    public void Actualizarempleado() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizardetalle(this.getId_detalleorden(), this.getCantidad());
        this.callApi();
          this.setCantidad(cantidad);
        modoEdicion = false;
    }

}
