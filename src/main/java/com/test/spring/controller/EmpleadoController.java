package com.test.spring.controller;

import com.test.spring.pojo.Empleados;
import com.test.spring.service.SpringRestConsumer;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "empleadosController")
@ViewScoped
public class EmpleadoController implements Serializable {
    private List<Empleados> lstEmpledos = new ArrayList<>();
    private String nombre;
    private String apellido;
    private String telefono;
    private String salario;

    public EmpleadoController() {
    }

    public List<Empleados> getLstEmpledos() {
        return lstEmpledos;
    }

    public void setLstEmpledos(List<Empleados> lstEmpledos) {
        this.lstEmpledos = lstEmpledos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstEmpledos = restConsumer.consumeApiEmpleados();
    }

    public void limpiar() {
        lstEmpledos.clear();
    }

    public void eliminarempledo(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraApiCliente(id);
        lstEmpledos = restConsumer.consumeApiEmpleados();
    }

    public void guardarempledo() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Empleados empleado = new Empleados(apellido, nombre, salario, telefono);
        restConsumer.guardaApiEmpleados(empleado);
        lstEmpledos = restConsumer.consumeApiEmpleados();
        limpiarCampos();
    }

    private void limpiarCampos() {
        nombre = null;
        apellido = null;
        telefono = null;
        salario = null;
    }
}