/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.Cliente;
import com.test.spring.pojo.Mesa;
import com.test.spring.service.SpringRestConsumer;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**ava.util.List;

/**
 *
 * @author hugo
 */
@Named(value="mesaController")
@ViewScoped
public class MesaController implements Serializable {
     List<Mesa> lstmesa = new ArrayList<>();
     private Integer id_mesa;
    private String capacidad;
    private Integer  id_restaurante;

    public List<Mesa> getLstmesa() {
        return lstmesa;
    }

    public void setLstmesa(List<Mesa> lstmesa) {
        this.lstmesa = lstmesa;
    }

    public Integer getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Integer id_mesa) {
        this.id_mesa = id_mesa;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Integer id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
    
    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstmesa = restConsumer.consumemesa();
    }
      public void limpiar() {
        lstmesa.clear();
    }
  public void eliminar(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borramesa(id);
        lstmesa = restConsumer.consumemesa();
    }

    public void guardar() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Mesa mesa = new Mesa(this.capacidad);
        restConsumer.guardarmesa(mesa);
        lstmesa = restConsumer.consumemesa();
    }

    
}
