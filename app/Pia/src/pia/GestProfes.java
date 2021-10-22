package pia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestProfes  {
void menu() {
        //Declaracion de obj
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

        //Declaracion de variables x
        int op;
        String bus;

        //Menu
        System.out.println("-----------------------------");
        System.out.println("   Gestionador de Maestros   ");
        System.out.println("-----------------------------");
        System.out.println("                         v1.0");
        do {
            System.out.println("Ingrese la opcion que desea realizar");
            System.out.println("1.- Agregar maestros ");
            System.out.println("2.- Buscar maestro ");
            System.out.println("3.- Mostrar maestros ");
            System.out.println("4.- Regresar Menu principal ");

            op = s.nextInt();
            switch (op) {
                case 1:
                    AgregarProfes();
                    break;
                case 2:
                    System.out.println("Ingrese en usuario a buscar ");
                    bus = s2.nextLine();
                    buscar_profe(bus);
                    break;
                case 3:
                    mostrar();
                    break;

            }

        } while (op != 4);
    }
    void AgregarProfes() {
        Scanner s = new Scanner(System.in);
        String nombre;
        String materia;
        String edad;
        String numero;
        String domicilio;
        

        ArrayList<Profes> prof = new ArrayList<Profes>();
        Profes profe;

        File profes = new File("profes.txt");
        if (profes.exists()) {
            System.out.println("Base De Datos detectada");

        } else {
            try {
                profes.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Capture el nombre del maestro");
        nombre = s.nextLine();
        System.out.println("Capture la materia de asignacion del maestro");
        materia = s.nextLine();
        System.out.println("Capture la edad del maestro");
        edad = s.nextLine();
        System.out.println("Capture el numero telefonico del maestro");
        numero = s.nextLine();
        System.out.println("Capture el domicilio del maestro");
        domicilio = s.nextLine();
       
        profe = new Profes(nombre, edad, numero, domicilio,materia);
        prof.add(profe);

        IngresaDatArchivos(profes, prof);

        mostrar();
    }

    static void IngresaDatArchivos(File file, ArrayList<Profes> prof) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));

            for (Profes a : prof) {
                
                bw.write(a.getNombre() + "\t\t;"+a.getMateria()+ "\t;"+ a.getEdad() + "\t;" + a.getNumero() + "\t\t;" + a.getDomicilio() + "\n");

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

    static void mostrar() {
        try {
            BufferedReader mostrar = new BufferedReader(new FileReader("profes.txt"));
            String cadena;
            System.out.println("\n");
            System.out.println("Nombre\t\tMateria\tEdad\tNumero\t\tDomicilio\n");
            while ((cadena = mostrar.readLine()) != null) {
                System.out.println("" + cadena);
            }
            System.out.println("\n");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

     void buscar_profe(String dato) {

        try {
            String profe = dato;
            BufferedReader leer = new BufferedReader(new FileReader("profes.txt"));

            String linea = "";
            
            while ((linea = leer.readLine()) != null) {
                if (linea.indexOf(profe) != -1) {
                    
                    System.out.println("\n" + "----Busqueda----");
                    System.out.println("Se Encontro:" + "\n");
                    System.out.println("Nombre\t\tMateria\tEdad\t\tNumero\tDomicilio\n");
                    System.out.println(linea + "\n");
                }

            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    
}
