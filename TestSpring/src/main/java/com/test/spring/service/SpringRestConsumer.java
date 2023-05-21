/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.service;

import com.test.spring.pojo.TServidor;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Xavier
 */
public class SpringRestConsumer {
   private RestTemplate restTemplate = new RestTemplate();

    public List<TServidor> consumeApi() {
        String url = "http://localhost:8871/servidores/getServidores"; // Cambia la URL para que coincida con tu API REST de Spring}
        List<TServidor> servidores = restTemplate.getForObject(url, List.class);
        //String response = restTemplate.getForObject(url, String.class);  
        return servidores;
    } 
}
