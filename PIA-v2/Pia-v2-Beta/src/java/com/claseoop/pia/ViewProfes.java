/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claseoop.pia;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.ArrayList;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewProfes")  
public class ViewProfes extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        
        response.setContentType("text/html");  
        ArrayList<WProfes> list =GestProfes.GetAllEmps();

        PrintWriter out=response.getWriter();  
        out.print("<body bgcolor=FFBFB2> ");
        out.println("<a href='Profes.html'>Agregar nuevo Maestro</a>");  
        out.println("<h1>Lista de Maestros</h1>");  
          
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Nombre</th><th>Edad</th><th>Numero</th><th>Domicilio</th><th>Materia</th>");  
        for(WProfes e:list){ 
            
            out.print("<tr><td>"+e.getNombre()+"</td><td>"+e.getEdad()+"</td><td>"+e.getDomicilio()+"</td><td>"+e.getNumero()+"</td><td>"+e.getMateria());  
        } 
        
        out.print("</table>");  
        out.print(" </body>");
        out.close();  
    }  
}  