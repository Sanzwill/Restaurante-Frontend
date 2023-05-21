/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.spring.controller;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.test.spring.pojo.Reporte;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo
 */
@Named
@ViewScoped
public class generarPdf implements  Serializable{
     List<Reporte> lstrepor = new ArrayList<>();
    public void generarPDF() {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\hugo\\Documents\\uni\\Decimo\\Aplicaciones distribuidas"));

            document.open();
            for (Reporte reporte : lstrepor) {
                document.add(new Paragraph("ID: " + reporte.getId_reporte()));
                document.add(new Paragraph("Nombre: " + reporte.getNombre()));
                document.add(new Paragraph("Fecha: " + reporte.getFecha_factura()));
                document.add(new Paragraph("Mesa: " + reporte.getId_mesa()));
                document.add(new Paragraph("Cliente: " + reporte.getId_cliente()));
                document.add(new Paragraph("Total: " + reporte.getTotal()));
                document.add(new Paragraph("NumeroFactura: " + reporte.getId_factura()));
               
                // Add more fields as needed  private Integer id_reporte; 
    
                document.add(new Paragraph("-----------------------"));
            }
            document.close();

            System.out.println("PDF generated successfully.");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    
}
