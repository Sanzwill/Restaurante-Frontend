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
@Named(value = "clienteController")
@ViewScoped
public class ClienteController implements Serializable {

    List<Cliente> lstLista = new ArrayList<>();
    private Long id_cliente;
    private String nombres;
    private String telefono;
    private String Apellido;
    private Cliente clienteEditando;
    private boolean modoEdicion;

    public List<Cliente> getLstLista() {
        return lstLista;
    }

    public void setLstLista(List<Cliente> lstLista) {
        this.lstLista = lstLista;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
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

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Cliente getClienteEditando() {
        return clienteEditando;
    }

    public void setClienteEditando(Cliente clienteEditando) {
        this.clienteEditando = clienteEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }
    
    
    
    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstLista = restConsumer.consumeApiCliente();
    }

    public void limpiar() {
        lstLista.clear();
    }

    public void eliminar(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraApiCliente(id);
        lstLista = restConsumer.consumeApiCliente();
    }

    public void guardarCliente() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Cliente cliente = new Cliente(this.nombres, this.telefono, this.Apellido);
        restConsumer.guardaApicliente(cliente);
        lstLista = restConsumer.consumeApiCliente();
        this.setNombres("");
        this.setApellido("");
        this.setTelefono("");

    }

    public void editarCliente(Long id_cliente, String nombres, String apellido, String telefono) {
        modoEdicion = true;
        this.setId_cliente(id_cliente);
        this.setNombres(nombres);
        this.setApellido(apellido);
        this.setTelefono(telefono);

    }
     public void Actualizarcliente() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizarclientess(this.getId_cliente(),this.getNombres(),this.getApellido(),this.getTelefono());
        this.callApi();
        this.setApellido("");
        this.setNombres("");
        this.setTelefono("");

        modoEdicion = false;
    }


}
