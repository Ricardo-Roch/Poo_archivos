package pia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestUsuarios  {

  public boolean flag= false;
Scanner s = new Scanner(System.in);
    void menu() {
        //Declaracion de obj
        
        Scanner s2 = new Scanner(System.in);

        //Declaracion de variables x
        int op;
        String bus;

        //Menu
        System.out.println("-----------------------------");
        System.out.println("   Gestionador de usuarios   ");
        System.out.println("-----------------------------");
        System.out.println("                         v1.0");
        do {
            System.out.println("Ingrese la opcion que desea realizar");
            System.out.println("1.- Agregar usuarios ");
            System.out.println("2.- Buscar Usuario ");
            System.out.println("3.- Mostrar usuarios ");
            System.out.println("4.- Regresar Menu principal ");

            op = s.nextInt();
            switch (op) {
                case 1:
                    //Se manda a llamar el metodo de agrergar usuarios
                    AgregarUs();
                    break;
                case 2:
                   
                    System.out.println("Ingrese en usuario a buscar ");
                    bus = s2.nextLine();
                     //Se manda a llamar el metodo de buscar_us usuarios
                    buscar_us(bus);
                    break;
                case 3:
                     //Se manda a llamar el metodo de mostrar_us usuarios
                    mostrar_us();
                    break;

            }

        } while (op != 4);
    }

    void AgregarUs() {
        Scanner s = new Scanner(System.in);
        String nombre;
        String tipo;
        String contra;
     
        //Declaracion de arreglo
        ArrayList<Usuarios> us = new ArrayList<Usuarios>();
        Usuarios usuario;

        
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

        System.out.println("Capture El nombre del usuarios");
        nombre = s.nextLine();
        System.out.println("Capture El tipo del usuarios");
        tipo = s.nextLine();
        System.out.println("Capture la contraseña del usuarios");
        contra = s.nextLine();
        
        //Ingresar(nombre,tipo,contra);
        
        
        usuario = new Usuarios(nombre, tipo, contra);
        us.add(usuario);

        IngresaUsArchivos(usuarios, us);

        //Método para leer el archivo / mostrar_us archivo
        mostrar_us();
    }

     void IngresaUsArchivos(File file, ArrayList<Usuarios> us) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));

            for (Usuarios a : us) {
                bw.write(a.getNombre() + ";" + a.getTipo() + ";" + a.getContra() + "\n");

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

//     void Ingresar(String nam,String contra,String tipo){
//         try {
//             BufferedWriter Fescribe= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("usuarios.txt")));
//             Fescribe.write(nam+contra+tipo+"\n");
//             Fescribe.close();
//             
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
    

     void buscar_us(String dato) {

        try {
            String usuario = dato;
            BufferedReader leer = new BufferedReader(new FileReader("usuarios.txt"));

            String linea = "";
            while ((linea = leer.readLine()) != null) {

                if (linea.indexOf(usuario) != -1) {
                    System.out.println("\n" + "----Busqueda----");
                    System.out.println("Se Encontro:" + "\n");
                    System.out.println("Nombre\tTipo\tContraseña\n");
                    System.out.println(linea + "\n");
                }

            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void mostrar_us() {
        try {
            BufferedReader mostrar = new BufferedReader(new FileReader("usuarios.txt"));
            String cadena;
            System.out.println("\n");
            while ((cadena = mostrar.readLine()) != null) {
                System.out.println("" + cadena);
            }
            System.out.println("\n");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    void logeo_us(String Nombre) {
        try {
            BufferedReader mostrar = new BufferedReader(new FileReader("usuarios.txt"));
            String nombre = "";
            String conra = "";
            System.out.println("\n");
            String linea = "";
            while ((linea = mostrar.readLine()) != null) 
            {
                do{
                
                if (linea.indexOf(nombre)!=-1)
                { 
                System.out.println(nombre);
                String[] parts = nombre.split(";");
                
                    String part1 = parts[0]; // nombre
                    String part2 = parts[1]; // contra    
                    String part3 = parts[2]; // tipo
                    
                    System.out.println("Ingrese la contraseña");
                    conra=s.nextLine();
                    if (conra==part2) {
                        System.out.println(nombre);
                        flag=true;
                        
                    }
                }
                
                }while(flag==true);
                
                
                
            }
            System.out.println("\n");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
//referencia
//https://www.youtube.com/watch?v=PhnEJ_Cr65k&ab_channel=ProgramArturo
}
