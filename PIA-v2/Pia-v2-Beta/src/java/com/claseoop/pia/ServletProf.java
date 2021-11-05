/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claseoop.pia;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ricardo
 */
@WebServlet(name = "GestProfes", urlPatterns = {"/GestProfes"})
public class ServletProf extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String nombre= request.getParameter("nombre");
        String edad= request.getParameter("edad");
        String numero= request.getParameter("numero");
        String domicilio= request.getParameter("domicilio");
        String materia= request.getParameter("materia");
        
        
        
        WProfes e = new WProfes();
        e.setNombre(nombre);
        e.setEdad(edad);
        e.setNumero(numero);
        e.setDomicilio(domicilio);
        e.setMateria(materia);
       
        
        
        int status= GestProfes.GuardarArray(e);
        if(status>0){
            out.print("<p><marquee>Maestro registrado Correctamente</marquee></p>");
        request.getRequestDispatcher("Profes.html").include(request, response);
        }else{
            
       out.print("<p>No se pudo agregar</p>");

        }
        out.close();
        
    }


}
