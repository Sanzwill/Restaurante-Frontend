/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;
import com.test.spring.pojo.Reporte;
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
@Named(value="reporteController")
@ViewScoped
public class reportecontroller implements  Serializable{
     List<Reporte> lstrepor = new ArrayList<>();
      private Integer id_reporte; 
        private Integer id_factura;
        private Integer id_cliente;
        private Integer id_mesa;
        private Integer fecha_factura;
        private String total;
        private String nombre; 
         private Reporte reportEditando;
    private boolean modoEdicion;

    public List<Reporte> getLstrepor() {
        return lstrepor;
    }

    public void setLstrepor(List<Reporte> lstrepor) {
        this.lstrepor = lstrepor;
    }

    public Integer getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(Integer id_reporte) {
        this.id_reporte = id_reporte;
    }

    public Integer getId_factura() {
        return id_factura;
    }

    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Integer id_mesa) {
        this.id_mesa = id_mesa;
    }

    public Integer getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(Integer fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Reporte getReportEditando() {
        return reportEditando;
    }

    public void setReportEditando(Reporte reportEditando) {
        this.reportEditando = reportEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

     public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstrepor = restConsumer.consumereporte();
    }
      public void limpiar() {
        lstrepor.clear();
    }
  public void eliminar(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borrareporte(id);
        lstrepor= restConsumer.consumereporte();
    }
      

}
