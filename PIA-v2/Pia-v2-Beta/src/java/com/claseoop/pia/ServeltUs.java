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
@WebServlet(name = "Servlet", urlPatterns = {"/SaveServlet"})
public class ServeltUs extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String nombre= request.getParameter("nombre");
        String tipo= request.getParameter("tipo");
        String contra= request.getParameter("contra");
        
        
        
        WUsuarios e = new WUsuarios();
        e.setNombre(nombre);
        e.setTipo(tipo);
        e.setContra(contra);
        
        
        int status= GestUsuarios.SaveEmp(e);
        if(status>0){
            out.print("<p><marquee>Usuario Agregado Correctamente</marquee></p>");
        request.getRequestDispatcher("index.html").include(request, response);
        }else{
            
       out.print("<p>No se pudo agregar</p>");

        }
        out.close();
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */


}
