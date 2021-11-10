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
    boolean verifica= false;
    boolean existe = true;

int i=0;
private String nom,mat;
    void menu() {
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
        System.out.println("                         v2.0");
        do {
            System.out.println("Ingrese la opcion que desea realizar");
            System.out.println("1.- Generar Horario");
            System.out.println("2.- Mostrar Horario");
            System.out.println("3.- Regresar Menu principal ");

            op = s.nextInt();
            switch (op) {
                case 1:
                    
                    do {
                    System.out.println("¿En que horario desea realizar?");
                    
                    System.out.println("1.-) h1->7:00-8:00");
                    System.out.println("2.-) h2->8:00-9:00");
                    System.out.println("3.-) h3->9:00-10:00");
                    System.out.println("4.-) h4->10:00-11:00");
                    System.out.println("5.-) h5->11:00-12:00");
                    
                    i = s.nextInt();

                       veri("h"+i);

                    } while (verifica != true);
                    verifica=false;
                    
                    AgregarHorario();
                    break;
                case 2:
                    mostrar_hor();
                    break;

                default:
                    System.out.println("Opcion Incorrecta");

            }

        } while (op != 3);
    }

    void AgregarHorario() {
        Scanner s = new Scanner(System.in);
        String lunes="";
        String martes="";
        String miercoles="";
        String jueves="";
        String viernes="";
        
        String h1="";
        String h2="";
        String h3="";
        String h4="";
        String h5="";
        
       

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
        
         
        
        
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: h"+i+" Del dia Lunes");
        buscar_profe(s.nextLine());
        lunes=nom;
        h1=mat;
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: h"+i+" Del dia Martes");
        buscar_profe(s.nextLine());
        martes=nom;
        h2=mat;
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: h"+i+" Del dia Miercoles");
        buscar_profe(s.nextLine());
        miercoles=nom;
        h3=mat;
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: h"+i+" Del dia Jueves");
        buscar_profe(s.nextLine());
        jueves=nom;
        h4=mat;
        System.out.println("Ingrese El nombre del maestro correspondiente del horario: h"+i+" Del dia Viernes");
        buscar_profe(s.nextLine());
        viernes=nom;
        h5=mat;
        
        mates = new Materias(lunes+"\t" ,martes+"\t" , miercoles+"\t" , jueves+"\t" , viernes);
        materias.add(mates);
         
        lunes=h1;
        martes="\t"+h2;
        miercoles="\t"+h3;
        jueves="\t"+h4;
        viernes="\t"+h5;
        
        mates=new Materias(lunes ,martes, miercoles, jueves, viernes);
        materias.add(mates);
        lunes="h"+i;
        martes="\t"+"h"+i;
        miercoles="\t"+"h"+i;
        jueves="\t"+"h"+i;
        viernes="\t"+"h"+i+"\n";
        
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

                bw.write(a.getLunes() + "\t\t" + a.getMartes() + "\t\t" + a.getMiercoles() + "\t\t" + a.getJueves() + "\t\t" + a.getViernes()+ "\n");

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
            System.out.println("Lunes \t\t\t Martes \t\t Miercoels \t\t Jueves \t\t Viernes\n");
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
    
void veri(String bus){
     try {  
            
            String dato = bus;
            System.out.println(dato);
            BufferedReader mostrar = new BufferedReader(new FileReader("horario.txt"));
            String linea = "";
            
            if (mostrar.readLine()==null) {
                existe=false;
             
         }
          
            while ((linea = mostrar.readLine()) != null) {
               // System.out.println(linea);
                if (linea.indexOf(dato) != -1) {
                    
                    existe=true;
                    System.out.println("El horario ya esta ocupado, ingrese un horario valido");
                    break;
                }else{
                    existe= false;
                    
                }

            }
            System.out.println("hola");
            if (existe==false){
                
                verifica=true;
                existe= true;
            }
          
            
            System.out.println("\n");
        } catch (Exception ex) {
            System.out.println(ex);
        }
       
            
    
    
}
}
