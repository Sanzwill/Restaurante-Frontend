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
import java.util.Date;
import java.util.List;


@Named(value="facturaController")
@ViewScoped
public class FacturaController implements Serializable{
    
    List <Factura> lstfactura=new ArrayList<>();
    private Long idFactura;
  private Date fechaFactura;
    private String total;

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

  

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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
        Factura factu = new Factura(this.fechaFactura,  this.total);
        restConsumer.guardaApifactura(factu);
        lstfactura= restConsumer.consumeApifactura();
    }

    

}
