package pia;

public class Profes {

    //Atributos
    private String nombre;
    private String materia;
    private String edad;
    private String numero;
    private String domicilio;
    //Constructores

    Profes(String nombre, String edad, String numero, String domicilio, String materia) {
        setNombre(nombre);
        setEdad(edad);
        setNumero(numero);
        setDomicilio(domicilio);
        setMateria(materia);

    }
    //Encapsulacion

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the materia
     */
    public String getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

}
