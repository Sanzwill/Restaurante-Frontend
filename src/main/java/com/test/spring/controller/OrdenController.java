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
import java.util.List;

/**
 *
 * @author hugo
 */
@Named(value="ordenController")
@ViewScoped
public class OrdenController implements Serializable{
     List<Orden> lstorden = new ArrayList<>();
    private Integer idOrden;
            private String fechaHora;
            private Integer id_mesa;
            private Integer id_empleado;

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

    public Integer getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Integer id_mesa) {
        this.id_mesa = id_mesa;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
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
        Orden orden = new Orden(this.fechaHora);
        restConsumer.guardarorden(orden);
        lstorden = restConsumer.consumeOrden();
    }

    
}
