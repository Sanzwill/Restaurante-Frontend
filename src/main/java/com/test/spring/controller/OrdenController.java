/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.Orden;
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
@Named(value = "ordenController")
@ViewScoped
public class OrdenController implements Serializable {

    List<Orden> lstorden = new ArrayList<>();
    private Integer idOrden;
    private String fechaHora;
    private String nombre_plato;
    private Orden ordenteEditando;
    private boolean modoEdicion;

    public List<Orden> getLstorden() {
        return lstorden;
    }

    public void setLstorden(List<Orden> lstorden) {
        this.lstorden = lstorden;
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

    public Orden getOrdenteEditando() {
        return ordenteEditando;
    }

    public void setOrdenteEditando(Orden ordenteEditando) {
        this.ordenteEditando = ordenteEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }



    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstorden = restConsumer.consumeOrden();
    }

    public void limpiar() {
        lstorden.clear();
    }

    public void eliminarorden(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraOrden(id);
        lstorden = restConsumer.consumeOrden();
    }

    public void guardarorden() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Orden orden = new Orden(this.fechaHora, this.nombre_plato);
        restConsumer.guardarorden(orden);
        lstorden = restConsumer.consumeOrden();
        this.setFechaHora("");
        this.setNombre_plato("");
    }
    public void editar(Integer idOrden, String nombre_plato, String fechaHora) {
        modoEdicion = true;
        this.setIdOrden(idOrden);
        this.setFechaHora(fechaHora);
        this.setNombre_plato(nombre_plato);
    

    }

    public void ActualizarCliente() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizarorden(this.getIdOrden(), this.getNombre_plato(), this.getFechaHora());
        this.callApi();
        this.setFechaHora("");
        this.setNombre_plato("");
        
        modoEdicion = false;
    }

}
