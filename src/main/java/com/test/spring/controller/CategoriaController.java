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

    public CategoriaController() {
    }

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

//    public void guardaCategoria() {
//        SpringRestConsumer restConsumer = new SpringRestConsumer();
//        Categoria categoria = new Categoria(this.nombre);
//        restConsumer.guardaCategoria(categoria);
//        lstcatego = restConsumer.consumirApicategoria();
//    }
public void guardaCategoria() {
    SpringRestConsumer restConsumer = new SpringRestConsumer();
    
    // Verificar si hay un ID eliminado disponible
    Integer idDisponible = encontrarIdDisponible();
    if (idDisponible != null) {
        Categoria categoria = new Categoria(this.nombre);
        restConsumer.guardaCategoria(categoria);
    } else {
        Categoria categoria = new Categoria(this.nombre);
        restConsumer.guardaCategoria(categoria);
    }
    
    lstcatego = restConsumer.consumirApicategoria();
}

private Integer encontrarIdDisponible() {
    Integer idDisponible = null;
    
    // Verificar si hay un ID eliminado en la lista de categorías
    for (Categoria categoria : lstcatego) {
        if (categoria.getId_categoria() == null) {
            idDisponible = categoria.getId_categoria();
            break;
        }
    }
    
    return idDisponible;
}

    
    
}
