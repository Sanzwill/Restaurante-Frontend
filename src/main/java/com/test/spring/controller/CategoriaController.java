/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.Categoria;
import com.test.spring.service.SpringRestConsumer;;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo
 */
@Named(value="categoriaController")
@ViewScoped
public class CategoriaController implements Serializable{
     List <Categoria> lstcatego =new ArrayList<>();
    private Integer id_categoria;
    private String nombre;
  private Categoria cateEditando;
    private boolean modoEdicion;

    public List<Categoria> getLstcatego() {
        return lstcatego;
    }

    public void setLstcatego(List<Categoria> lstcatego) {
        this.lstcatego = lstcatego;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCateEditando() {
        return cateEditando;
    }

    public void setCateEditando(Categoria cateEditando) {
        this.cateEditando = cateEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }
   
 public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstcatego = restConsumer.consumirApicategoria();
    }

    public void limpiar() {
        lstcatego.clear();
    }

    public void borraApiCategoria(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraApiCategoria(id);
        lstcatego = restConsumer.consumirApicategoria();
    }

   public void guardaCategoria() {
       SpringRestConsumer restConsumer = new SpringRestConsumer();
       Categoria categoria = new Categoria(this.nombre);
       restConsumer.guardaCategoria(categoria);
       lstcatego = restConsumer.consumirApicategoria();
       this.setNombre("");
   }

 

    public void editar(Integer id_categoria, String nombre) {
        modoEdicion = true;
        this.setId_categoria(id_categoria);
        this.setNombre(nombre);
        

    }

    public void ActualizarCate() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizarcategoria(this.getId_categoria(), this.getNombre());
        this.callApi();
        this.setNombre("");
       
        modoEdicion = false;
    }

    
}
