/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

/**
 *
 * @author hugo
 */
import com.test.spring.pojo.Plato;
import com.test.spring.service.SpringRestConsumer;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

@Named(value = "platoController")
@ViewScoped
public class PlatoController implements Serializable {

    List<Plato> lstplato = new ArrayList<>();
    private Integer id_plato;
    private String nombre;
    private String descripcion;
    private String precio;
    private Plato platoteEditando;
    private boolean modoEdicion;

    public List<Plato> getLstplato() {
        return lstplato;
    }

    public void setLstplato(List<Plato> lstplato) {
        this.lstplato = lstplato;
    }

    public Integer getId_plato() {
        return id_plato;
    }

    public void setId_plato(Integer id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Plato getPlatoteEditando() {
        return platoteEditando;
    }

    public void setPlatoteEditando(Plato platoteEditando) {
        this.platoteEditando = platoteEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }


    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstplato = restConsumer.consumeApiPalto();
    }

    public void limpiar() {
        lstplato.clear();
    }

    public void eliminar(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraPalto(id);
        lstplato = restConsumer.consumeApiPalto();
    }

    public void guardar() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Plato plato = new Plato(this.descripcion, this.nombre, this.precio);
        restConsumer.guardaApipalto(plato);
        lstplato = restConsumer.consumeApiPalto();
        this.setDescripcion("");
        this.setNombre("");
        this.setPrecio("");
    }
    
     public void editar(Integer id_plato, String descripcion, String nombre, String precio) {
        modoEdicion = true;
        this.setId_plato(id_plato);
        this.setDescripcion(descripcion);
        this.setNombre(nombre);
        this.setPrecio(precio);
       

    }

    public void Actualizarplato() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizarplato(this.getId_plato(), this.getNombre(), this.getDescripcion(), this.getPrecio());
        this.callApi();
        this.setDescripcion("");
        this.setNombre("");
        this.setPrecio("");
        
        modoEdicion = false;
    }


}
