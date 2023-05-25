/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.pojo;

public class Factura {

    
    private Long id_factura;
    private String fecha_factura;
    private String total;

    public Factura(String fecha_factura, String total) {
        this.fecha_factura = fecha_factura;
        this.total = total;
    }

 
    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    

}