/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.Factura;
import com.test.spring.service.SpringRestConsumer;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

@Named(value = "facturaController")
@ViewScoped
public class FacturaController implements Serializable {

    List<Factura> lstfactura = new ArrayList<>();
    private Long idFactura;
    private String fechaFactura;
    private String total;
    private Factura facturaEditando;
    private boolean modoEdicion;

    public List<Factura> getLstfactura() {
        return lstfactura;
    }

    public void setLstfactura(List<Factura> lstfactura) {
        this.lstfactura = lstfactura;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Factura getFacturaEditando() {
        return facturaEditando;
    }

    public void setFacturaEditando(Factura facturaEditando) {
        this.facturaEditando = facturaEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstfactura = restConsumer.consumeApifactura();
    }

    public void limpiar() {
        lstfactura.clear();
    }

    public void Eliminarfactura(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraApifactura(id);
        lstfactura = restConsumer.consumeApifactura();
    }

    public void guardarfactura() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Factura factu = new Factura(this.fechaFactura, this.total);
        restConsumer.guardaApifactura(factu);
        lstfactura = restConsumer.consumeApifactura();
      
        this.setTotal("");
        
       
    }
     public void editarfactura(long idfactura, String total , String fechaFactura) {
        modoEdicion = true;
        this.setIdFactura(idfactura);
        this.setFechaFactura(fechaFactura);
        this.setTotal(total);

    }

    public void ActualizarCliente() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizarfactur(this.getIdFactura(), this.getFechaFactura(),this.getTotal());
        this.callApi();
        this.setFechaFactura("");
        this.setTotal("");
       
        modoEdicion = false;
    }
    
    

}
