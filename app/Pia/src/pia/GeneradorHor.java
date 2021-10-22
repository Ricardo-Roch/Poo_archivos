package pia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneradorHor {
    
int i=0;
private String nom,mat;
    void menu() {
        //Declaracion de obj
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

        //Declaracion de variables x
        int op;
        String bus;

        //Menu
        System.out.println("-----------------------------");
        System.out.println("   Generador de Horarios  ");
        System.out.println("-----------------------------");
        System.out.println("                         v1.0");
        do {
            System.out.println("Ingrese la opcion que desea realizar");
            System.out.println("1.- Generar Horario");
            System.out.println("2.- Regresar Menu principal ");

            op = s.nextInt();
            switch (op) {
                case 1:
                    System.out.println("¿En que horario desea realizar?");
                    System.out.println("1.-) m1->7:00-8:00");
                    System.out.println("2.-) m2->8:00-9:00");
                    System.out.println("3.-) m3->9:00-10:00");
                    System.out.println("4.-) m4->10:00-11:00");
                    System.out.println("5.-) m5->11:00-12:00");
                    i=s.nextInt();
                    AgregarHorario();
                    break;

                

            }

        } while (op != 2);
    }

    void AgregarHorario() {
        Scanner s = new Scanner(System.in);
        String lunes="";
        String martes="";
        String miercoles="";
        String jueves="";
        String viernes="";
        
        String m1="";
        String m2="";
        String m3="";
        String m4="";
        String m5="";
        
       

        ArrayList<Materias> materias = new ArrayList<Materias>();
        Materias mates;

        File materi = new File("horario.txt");
        if (materi.exists()) {
            System.out.println("Base De Datos detectada");

        } else {
            try {
                materi.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
         
        
        
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: m"+i+" Del dia Lunes");
        buscar_profe(s.nextLine());
        lunes=nom;
        m1=mat;
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: m"+i+" Del dia Martes");
        buscar_profe(s.nextLine());
        martes=nom;
        m2=mat;
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: m"+i+" Del dia Miercoles");
        buscar_profe(s.nextLine());
        miercoles=nom;
        m3=mat;
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: m"+i+" Del dia Jueves");
        buscar_profe(s.nextLine());
        jueves=nom;
        m4=mat;
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: m"+i+" Del dia Viernes");
        buscar_profe(s.nextLine());
        viernes=nom;
        m5=mat;
        mates = new Materias(lunes ,martes, miercoles, jueves, viernes);
        materias.add(mates);
         
        lunes=m1;
        martes="\t"+m2;
        miercoles="\t"+m3;
        jueves="\t"+m4;
        viernes="\t"+m5;
        
        mates=new Materias(lunes ,martes, miercoles, jueves, viernes);
        materias.add(mates);
        lunes="m"+i;
        martes="\t\t"+"m"+i;
        miercoles="\t\t"+"m"+i;
        jueves="\t\t"+"m"+i;
        viernes="\t\t"+"m"+i+"\n";
        
        mates=new Materias(lunes ,martes, miercoles, jueves, viernes);
        materias.add(mates);
        IngresaDatArchivos(materi, materias);
        i++;
          
        mostrar_hor();
    }

    static void IngresaDatArchivos(File file, ArrayList<Materias> materias) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file,true));

            for (Materias a : materias) {

                bw.write(a.getLunes() + "\t" + a.getMartes() + "" + a.getMiercoles() + "\t" + a.getJueves() + "" + a.getViernes()+ "\n");

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

    void mostrar_hor() {
        try {
            BufferedReader mostrar = new BufferedReader(new FileReader("horario.txt"));
            String cadena;
            System.out.println("\n");
            System.out.println("Lunes \t\t\t Martes \t Miercoels \t\t Jueves \t Viernes\n");
            while ((cadena = mostrar.readLine()) != null) {
                System.out.println("" + cadena);
            }
            System.out.println("\n");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
     void buscar_profe(String dato) {
           
         String usuario= dato;

        try {
            BufferedReader leer = new BufferedReader(new FileReader("profes.txt"));

            String linea = "";
            
            while ((linea = leer.readLine()) != null) 
            {
                if (linea.indexOf(usuario)!=-1)
                {
                    
                     //System.out.println(linea);
                     
                     
                    String[] parts = linea.split(";");
                    String part1 = parts[0]; // nombre
                    String part2 = parts[1]; // materia
                    String part3 = parts[2]; // edad
                    String part4 = parts[3]; // numero
                    String part5 = parts[4]; // domicilio
                    
                    nom=part1;
                  
                    mat=part2; 
                    
                    System.out.println(part1 + part2);
                    
                 }

            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    

}
