/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Santo Tomas
 */
public class Autor {
    private int id;
    private String nombre; //(3, 20)
    private String nacionalidad; //(3, 20)

    public Autor() {
    }

    public Autor(int id, String nombre, String nacionalidad) {
        this.id = id;
        setNombre(nombre);
        setNacionalidad(nacionalidad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() > 60){
            throw new IllegalArgumentException("El nombre NO debe estar vacio o no puede superar los 60 caracteres");
        }
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    

    public void setNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.isEmpty()){
            throw new IllegalArgumentException("La nacionalidad no debe estar vacia o no debe ser nula");
        }
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
}
