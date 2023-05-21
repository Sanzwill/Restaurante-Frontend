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


@Named(value="facturaController")
@ViewScoped
public class FacturaController implements Serializable{
    
    List <Factura> lstfactura=new ArrayList<>();
    private Long id_factura;
    private Long id_cliente;
    private String num_mesa;
    private String metodo_pago;
    private String total;
    private String fecha_transacion;

    public List<Factura> getLstfactura() {
        return lstfactura;
    }

    public void setLstfactura(List<Factura> lstfactura) {
        this.lstfactura = lstfactura;
    }

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(String num_mesa) {
        this.num_mesa = num_mesa;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha_transacion() {
        return fecha_transacion;
    }

    public void setFecha_transacion(String fecha_transacion) {
        this.fecha_transacion = fecha_transacion;
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
        Factura factu = new Factura(this.num_mesa, this.metodo_pago, this.fecha_transacion, this.total);
        restConsumer.guardaApifactura(factu);
        lstfactura= restConsumer.consumeApifactura();
    }

    

}
