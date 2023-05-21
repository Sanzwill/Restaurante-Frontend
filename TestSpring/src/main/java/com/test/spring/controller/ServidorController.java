/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.test.spring.pojo.TServidor;
import com.test.spring.service.SpringRestConsumer;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier
 */
@Named(value="servidorController")
@ViewScoped
public class ServidorController implements Serializable{
    
    List <TServidor> lstServidores=new ArrayList<>();
    
    public void callApi(){
        SpringRestConsumer restConsumer=new SpringRestConsumer();
        lstServidores = restConsumer.consumeApi();
        addMessage(FacesMessage.SEVERITY_INFO, "Servidores", "La lista fue cargada correctamente");
    }
    
    public void limpiar(){
        lstServidores.clear();
        addMessage(FacesMessage.SEVERITY_INFO, "Atención", "Lista Limpiada");
    }
public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    public List<TServidor> getLstServidores() {
        return lstServidores;
    }

    public void setLstServidores(List<TServidor> lstServidores) {
        this.lstServidores = lstServidores;
    }
    
    
}
