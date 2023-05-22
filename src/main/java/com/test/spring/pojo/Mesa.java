/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.pojo;

/**
 *
 * @author hugo
 */
public class Mesa {
    private Integer id_mesa;
    private String 	numero_mesa;
    private String capacidad;

    public Mesa(String numero_mesa, String capacidad) {
        this.numero_mesa = numero_mesa;
        this.capacidad = capacidad;
    }

 

    public Integer getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Integer id_mesa) {
        this.id_mesa = id_mesa;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getNumero_mesa() {
        return numero_mesa;
    }

    public void setNumero_mesa(String numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

  
    
    
}
