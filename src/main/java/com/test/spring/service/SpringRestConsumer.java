/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.service;

import com.test.spring.pojo.Categoria;
import com.test.spring.pojo.Cliente;
import com.test.spring.pojo.Detalle;
import com.test.spring.pojo.Empleados;
import com.test.spring.pojo.Factura;
import com.test.spring.pojo.Mesa;
import com.test.spring.pojo.Orden;
import com.test.spring.pojo.Plato;
import com.test.spring.pojo.Reporte;
import com.test.spring.pojo.Restaurante;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class SpringRestConsumer {
   private RestTemplate restTemplate = new RestTemplate();
 

    public List<Factura> consumeApifactura() {
        String url = "http://localhost:8871/facturas"; // Cambia la URL para que coincida con tu API REST de Spring}
        List<Factura> servidores = restTemplate.getForObject(url, List.class);
        //String response = restTemplate.getForObject(url, String.class);  
        return servidores;
    } 
       public void borraApifactura(int id) {
        String url = "http://localhost:8871/facturas/";
        restTemplate.delete(url + id);
    }

    public void guardaApifactura(Factura factura) {
        String url = "http://localhost:8871/factutas/facturas";
        ResponseEntity<Factura> response = restTemplate.postForEntity(url, factura, Factura.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
//
//    categoria
    
        public List<Categoria> consumirApicategoria() {
        String url = "http://localhost:8871/categorias";
        List<Categoria> categoria = restTemplate.getForObject(url, List.class);
        return categoria;
    }

    public void borraApiCategoria(int id) {
        String url = "http://localhost:8871/categorias/";
        restTemplate.delete(url + id);
    }

    public void guardaCategoria(Categoria categoria) {
        String url = "http://localhost:8871/categorias/catego";
        ResponseEntity<Categoria> response = restTemplate.postForEntity(url, categoria, Categoria.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar la categoria en la API: " + response.getStatusCodeValue());
        }
    }
    
//    cliente
    
           public List<Cliente> consumeApiCliente() {
        String url = "http://localhost:8871/clientes/";
        List<Cliente> clientes = restTemplate.getForObject(url, List.class);
        return clientes;
    }

    public void borraApiCliente(int id) {
        String url = "http://localhost:8871/clientes/";
        restTemplate.delete(url + id);
    }
       //    public void borraApiCliente(int id) {
//    String url = "http://localhost:8871/clientes/" + id;
//    restTemplate.delete(url);
//}

    public void guardaApiCliente(Cliente cliente) {
        String url = "http://localhost:8871/clientes/clientes";
        ResponseEntity<Cliente> response = restTemplate.postForEntity(url, cliente, Cliente.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
    public void actualizaApiCliente(Cliente cliente) {
    String url = "http://localhost:8871/clientes/" + cliente.getId_cliente();
    restTemplate.put(url, cliente);
}

//    detalle 
     
    
   public List<Detalle> consumeApiDetalle() {
        String url = "http://localhost:8871/api/detalleordenes";
        List<Detalle> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borraApiDetalle(int id) {
        String url = "http://localhost:8871/api/";
        restTemplate.delete(url + id);
    }

    public void guardaApiDetalle(Detalle detalle) {
        String url = "http://localhost:8871/api/detalleordenes";
        ResponseEntity<Detalle> response = restTemplate.postForEntity(url, detalle, Detalle.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
//    Empleados
    public List<Empleados> consumeApiEmpleados() {
        String url = "http://localhost:8871/empleados";
        List<Empleados> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borraApiEmpleados(int id) {
        String url = "http://localhost:8871/empleados";
        restTemplate.delete(url + id);
    }

    public void guardaApiEmpleados(Empleados empleados) {
        String url = "http://localhost:8871/empleados/guardarEmpleado";
        ResponseEntity<Empleados> response = restTemplate.postForEntity(url, empleados, Empleados.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
    
//     restauranre 
    public List<Restaurante> consumeApiRestaurante() {
        String url = "http://localhost:8871/restaurante";
        List<Restaurante> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borrarestaurante(int id) {
        String url = "http://localhost:8871/restaurantes/";
        restTemplate.delete(url + id);
    }

    public void guardaApiRestaurante(Restaurante restaurante) {
        String url = "http://localhost:8871/restaurante/guardar";
        ResponseEntity<Restaurante> response = restTemplate.postForEntity(url, restaurante, Restaurante.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
//    __Plato 
    
     public List<Plato> consumeApiPalto() {
        String url = "http://localhost:8871/platos/pla";
        List<Plato> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borraPalto(int id) {
        String url = "http://localhost:8871/platos/";
        restTemplate.delete(url + id);
    }

    public void guardaApipalto(Plato plato) {
        String url = "http://localhost:8871/platos/plato";
        ResponseEntity<Plato> response = restTemplate.postForEntity(url, plato, Plato.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
//    orden 
     public List<Orden> consumeOrden() {
        String url = "http://localhost:8871/ordenes";
        List<Orden> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borraOrden(int id) {
        String url = "http://localhost:8871/ordenes/";
        restTemplate.delete(url + id);
    }

    public void guardarorden(Orden orden) {
        String url = "http://localhost:8871/ordenes/ordenes";
        ResponseEntity<Orden> response = restTemplate.postForEntity(url, orden, Orden.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
//    mesa
    public List<Mesa> consumemesa() {
        String url = "http://localhost:8871/mesa";
        List<Mesa> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borramesa(int id) {
        String url = "http://localhost:8871/mesa/";
        restTemplate.delete(url + id);
    }

    public void guardarmesa(Mesa mesa) {
        String url = "http://localhost:8871/mesa/mesass";
        ResponseEntity<Mesa> response = restTemplate.postForEntity(url, mesa, Mesa.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
    
//    reporte
     public List<Reporte> consumereporte() {
        String url = "http://localhost:8871/Reporte/final";
        List<Reporte> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borrareporte(int id) {
        String url = "http://localhost:8871/Reporte/";
        restTemplate.delete(url + id);
    }

    
}