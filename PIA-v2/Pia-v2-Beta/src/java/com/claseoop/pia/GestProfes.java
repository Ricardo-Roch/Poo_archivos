/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claseoop.pia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public class GestProfes {

    private static ArrayList<WProfes> profes = new ArrayList<WProfes>();
        

    public static int GuardarArray(WProfes e) {
            WUsuarios usu;

        
        File usuarios = new File("usuarios.txt");
        
        if (usuarios.exists()) {
            //Leer(usuarios);
            //System.exit(1);

        } else {
            try {
                usuarios.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        if (e.getNombre() != null) {
            System.out.println(e.getNombre());
            profes.add(e);
            
            
            return 1;

        } else {
            return 0;
        }

    }

    public static ArrayList<WProfes>GetAllEmps(){
        return profes;
    }
    
     void IngresaUsArchivos(File file, ArrayList<WUsuarios> usu) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));

            for (WUsuarios a : usu) {
                bw.write(a.getNombre() + a.getTipo() +  a.getContra() + "\n");

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}