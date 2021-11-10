
package pia;

public class Usuarios {
//Atributos
    private String nombre;
    private String tipo;
    private String contra;
    
    
    
//Contructor
    Usuarios(String nombre, String tipo, String contra){
        setNombre(nombre);
        setTipo(tipo);
        setContra(contra);
        
    }

   //Encapsulacion
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    public String getTipo() {
        return tipo;
    }

   
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    public String getContra() {
        return contra;
    }


    public void setContra(String contra) {
        this.contra = contra;
    }

    
   
}
