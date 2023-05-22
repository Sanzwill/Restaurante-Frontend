/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.pojo;

import com.test.spring.service.SpringRestConsumer;
import java.util.Date;
import java.util.List;


public class Factura {

    
    private Long id_factura;
    private Date fecha_factura;
    private String total;

    public Factura(Date fecha_factura, String total) {
        this.fecha_factura = fecha_factura;
        this.total = total;
    }

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    

   
  
 
   

}
