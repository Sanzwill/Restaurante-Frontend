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
import com.test.spring.pojo.reservacion;
import java.util.Date;
import java.util.List;
import org.primefaces.shaded.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringRestConsumer {

    private RestTemplate restTemplate = new RestTemplate();

//Factura
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
        String url = "http://localhost:8871/facturas";
        ResponseEntity<Factura> response = restTemplate.postForEntity(url, factura, Factura.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }

    public String actualizarfactur(long idfactura, String total, String fechaFactura) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("idfactura", idfactura);
        jsonBody.put("total", total);
        jsonBody.put("fechaFactura", fechaFactura);

        String url = "http://localhost:8871/facturas/" + idfactura;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Factura Creada";
    }

//
//    ---------------------------/----categoria*----------------------------
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

    public String actualizarcategoria(Integer id_categoria, String nombre) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("id_categoria", id_categoria);
        jsonBody.put("nombre", nombre);

        String url = "http://localhost:8871/categorias/" + id_categoria;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Cliente Creado";
    }

//------------------------cliente--------------------------------
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

//    public void guardaApiCliente(Cliente cliente) {
//        String url = "http://localhost:8871/clientes/clientes";
//        ResponseEntity<Cliente> response = restTemplate.postForEntity(url, cliente, Cliente.class);
//        if (response.getStatusCode() != HttpStatus.OK) {
//            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
//        }
//    }
    public void guardaApicliente(Cliente cliente) {
        String url = "http://localhost:8871/clientes/clientes";
        restTemplate.postForEntity(url, cliente, Cliente.class);

    }

    public String actualizarclientess(Long id_cliente, String nombres, String apellido, String cedula) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("id_cliente", id_cliente);
        jsonBody.put("nombres", nombres);
        jsonBody.put("apellido", apellido);
       
        String url = "http://localhost:8871/clientes/" + id_cliente;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Cliente Creado";
    }

///-----------------------------   detalle---------------------------------- 
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

    public String actualizardetalle(Integer id_detalleorden, String cantidad) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("id_detalleorden", id_detalleorden);
        jsonBody.put("cantidad", cantidad);

        String url = "http://localhost:8871/api/detalleordenes" + id_detalleorden;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Cliente Creado";
    }
//   ---------------*------------------- Empleados*-------------------*-------------------

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

    public String actualizaEmpleado(Integer id_empleado, String nombre, String apellido, String telefono, String salario) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("id_empleado", id_empleado);
        jsonBody.put("nombre", nombre);
        jsonBody.put("apellido", apellido);
        jsonBody.put("salario", salario);
        jsonBody.put("telefono", telefono);

        String url = "http://localhost:8871/empleados/" + id_empleado;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Cliente Creado";
    }

//    --------------------------------- restauranre -------------* *------------------------------------
    public List<Restaurante> consumeApiRestaurante() {
        String url = "http://localhost:8871/restaurante";
        List<Restaurante> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borrarestaurante(int id) {
        String url = "http://localhost:8871/restaurante/";
        restTemplate.delete(url + id);
    }

    public void guardaApiRestaurante(Restaurante restaurante) {
        String url = "http://localhost:8871/restaurante/guardar";
        ResponseEntity<Restaurante> response = restTemplate.postForEntity(url, restaurante, Restaurante.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }

    public String actualizarrestau(Integer id_restaurante, String nombre, String direccion, String telefono) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("id_restaurante", id_restaurante);
        jsonBody.put("nombre", nombre);
        jsonBody.put("direccion", direccion);
        jsonBody.put("telefono", telefono);
        String url = "http://localhost:8871/restaurante" + id_restaurante;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Cliente Creado";
    }
//   ------------------------------------------ __Plato ***********************************---------------///***********************

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
      public String actualizarplato(Integer id_plato, String descripcion, String nombre, String precio) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("id_plato", id_plato);
        jsonBody.put("descripcion", descripcion);
        jsonBody.put("nombre", nombre);
        jsonBody.put("precio", precio);
  
        String url = "http://localhost:8871/platos/pla" + id_plato;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Cliente Creado";
    }
//    ---------------------------------orden----------------------------------------------------- 

    public List<Orden> consumeOrden() {
        String url = "http://localhost:8871/ordenes";
        List<Orden> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borraOrden(int id) {
        String url = "http://localhost:8871/ordenes/ordenes/" + id;
        restTemplate.delete(url);
    }

    public void guardarorden(Orden orden) {
        String url = "http://localhost:8871/ordenes/ordenes";
        ResponseEntity<Orden> response = restTemplate.postForEntity(url, orden, Orden.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
    
        public String actualizarorden(Integer idOrden, String nombre_plato, String fechaHora) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("idOrden", idOrden);
        jsonBody.put("nombre_plato", nombre_plato);
        jsonBody.put("fechaHora", fechaHora);
 
        String url = "http://localhost:8871/ordenes" + idOrden;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Orden Creado";
    }
//    --------------------------------------------mesa------------------------------------------------------------

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
 public String actualizarmesa(Integer id_mesa, String capacidad, String numero_mesa) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("id_mesa", id_mesa);
        jsonBody.put("capacidad", capacidad);
        jsonBody.put("numero_mesa", numero_mesa);
        String url = "http://localhost:8871/mesa" + id_mesa;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Cliente Creado";
    }
//   -------------------------------------------- reporte--------------------------------------------------------------------
    public List<Reporte> consumereporte() {
        String url = "http://localhost:8871/Reporte/final";
        List<Reporte> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borrareporte(int id) {
        String url = "http://localhost:8871/Reporte/";
        restTemplate.delete(url + id);
    }
    
//Reserva 

    public List<reservacion> consumereserva() {
        String url = "http://localhost:8871/reserva/";
        List<reservacion> deta = restTemplate.getForObject(url, List.class);
        return deta;
    }

    public void borrarreserva(int id) {
        String url = "http://localhost:8871/reserva/";
        restTemplate.delete(url + id);
    }

    public void guardarreserva(reservacion rese) {
        String url = "http://localhost:8871/reserva/reser";
        ResponseEntity<reservacion> response = restTemplate.postForEntity(url, rese, reservacion.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al guardar el cliente en la API: " + response.getStatusCodeValue());
        }
    }
      public String actualizarreserva(Integer id_reservacion, String duracion, String nombre_cliente, String fecha_hora) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("id_reservacion", id_reservacion);
        jsonBody.put("duracion", duracion);
        jsonBody.put("nombre_cliente", nombre_cliente);
        String url = "http://localhost:8871/reserva" + id_reservacion;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
        restTemplate.put(url, request);
        return "Cliente Creado";
    }
}
