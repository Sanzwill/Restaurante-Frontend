/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.Restaurante;
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
@Named(value = "restauController")
@ViewScoped
public class RestauranteController implements Serializable {
    private List<Restaurante> lstrestau = new ArrayList<>();
    private Integer id_restaurante;
    private String nombre;
    private String direccion;
    private String telefono;
    private Restaurante restaEditando;
    private boolean modoEdicion;

    public List<Restaurante> getLstrestau() {
        return lstrestau;
    }

    public void setLstrestau(List<Restaurante> lstrestau) {
        this.lstrestau = lstrestau;
    }

    public Integer getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Integer id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Restaurante getRestaEditando() {
        return restaEditando;
    }

    public void setRestaEditando(Restaurante restaEditando) {
        this.restaEditando = restaEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstrestau = restConsumer.consumeApiRestaurante();
    }
      public void limpiar() {
        lstrestau.clear();
    }
  public void eliminarrestaurante(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borrarestaurante(id);
        lstrestau = restConsumer.consumeApiRestaurante();
    }

    public void guardarrestaurante() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Restaurante res = new Restaurante(this.direccion,  this.telefono,this.nombre);
        restConsumer.guardaApiRestaurante(res);
        lstrestau = restConsumer.consumeApiRestaurante();
        this.setDireccion("");
        this.setNombre("");
        this.setTelefono("");
        
    }
     public void editarCliente(Integer id_restaurante, String nombre, String direccion, String telefono) {
        modoEdicion = true;
        this.setDireccion(direccion);
        this.setNombre(nombre);
        this.setId_restaurante(id_restaurante);
        this.setTelefono(telefono);
      
    }

    public void Actualizarrestautante() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizarrestau(this.getId_restaurante(), this.getNombre(), this.getTelefono(), this.getDireccion());
        this.callApi();
       this.setDireccion("");
        this.setNombre("");
        this.setTelefono("");
        modoEdicion = false;
    }
}

