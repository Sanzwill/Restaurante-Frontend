/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.Cliente;
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
@Named(value="clienteController")
@ViewScoped
public class ClienteController implements Serializable{
     List<Cliente> lstLista = new ArrayList<>();
    private Integer id_cliente;
    private String nombres;
    private String telefono;

    public ClienteController() {
    }

    public List<Cliente> getLstLista() {
        return lstLista;
    }

    public void setLstLista(List<Cliente> lstLista) {
        this.lstLista = lstLista;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstLista = restConsumer.consumeApiCliente();
    }
      public void limpiar() {
        lstLista.clear();
    }
  public void eliminarCliente(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraApiCliente(id);
        lstLista = restConsumer.consumeApiCliente();
    }

    public void guardarCliente() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Cliente cliente = new Cliente(this.nombres,  this.telefono);
        restConsumer.guardaApiCliente(cliente);
        lstLista = restConsumer.consumeApiCliente();
    }

public void actualizarCliente(Cliente cliente) {
    SpringRestConsumer restConsumer = new SpringRestConsumer();
    restConsumer.actualizaApiCliente(cliente);
    lstLista = restConsumer.consumeApiCliente();
}


    
}
