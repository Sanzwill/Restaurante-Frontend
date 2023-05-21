/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.pojo;

import com.test.spring.service.SpringRestConsumer;
import java.util.List;


public class Factura {

    
    private Long id_factura;
    private Long id_cliente;
    
    private String num_mesa;
    private String metodo_pago;
    private String total;
    private String fecha_transacion;

    public Factura() {
    }

    public Factura(String num_mesa, String metodo_pago, String total, String fecha_transacion) {
  
        this.num_mesa = num_mesa;
        this.metodo_pago = metodo_pago;
        this.total = total;
        this.fecha_transacion = fecha_transacion;
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

   
  
 
   

}
