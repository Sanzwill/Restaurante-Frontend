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
     private Integer id_empleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String salario;
      private Empleados EmpleadoEditando;
    private boolean modoEdicion;

    public List<Empleados> getLstEmpledos() {
        return lstEmpledos;
    }

    public void setLstEmpledos(List<Empleados> lstEmpledos) {
        this.lstEmpledos = lstEmpledos;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
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

    public Empleados getEmpleadoEditando() {
        return EmpleadoEditando;
    }

    public void setEmpleadoEditando(Empleados EmpleadoEditando) {
        this.EmpleadoEditando = EmpleadoEditando;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    

    public void callApi() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        lstEmpledos = restConsumer.consumeApiEmpleados();
    }

    public void limpiar() {
        lstEmpledos.clear();
    }

    public void eliminar(int id) {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        restConsumer.borraApiCliente(id);
        lstEmpledos = restConsumer.consumeApiEmpleados();
    }

    public void guardarempledo() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        Empleados empleado = new Empleados(this.apellido, this.nombre, this.salario, this.telefono);
        restConsumer.guardaApiEmpleados(empleado);
        lstEmpledos = restConsumer.consumeApiEmpleados();
        this.setNombre("");
        this.setApellido("");
        this.setSalario("");
        this.setTelefono("");
    }

   

    public void editarempleado(Integer id_empleado, String nombre, String apellido, String telefono, String salario) {
        this.modoEdicion = true;
        this.setId_empleado(id_empleado);
        this.setApellido(apellido);
        this.setNombre(nombre);
        this.setSalario(salario);
        this.setTelefono(telefono);
       
       
        
    }

    public void Actualizarempleado() {
        SpringRestConsumer restConsumer = new SpringRestConsumer();
        String response = restConsumer.actualizaEmpleado(this.getId_empleado(), this.getNombre(), this.getApellido(), this.getTelefono(),this.getSalario());
        this.callApi();
        this.setApellido("");
        this.setNombre("");
        this.setSalario("");
        this.setTelefono("");

        modoEdicion = false;
    }
}