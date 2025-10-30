/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Santo Tomas
 */
public class Libro{
    private int id;
    private String titulo; //(3, 20)
    private int aniopublicacion; //(4)
    private Autor autor;
    public Libro() {
    }

    public Libro(int id, String titulo, int aniopublicacion, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.aniopublicacion = aniopublicacion;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0){
            throw new IllegalArgumentException("La id debe ser mayor a 0");
        }
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.length() > 100){
            throw new IllegalArgumentException("El titulo no puede ser nulo, ni tampoco puede superar los 100 caracteres");
        }
        this.titulo = titulo;
    }

    public int getAniopublicacion() {
        return aniopublicacion;
    }

    public void setAniopublicacion(int aniopublicacion) {
        if(aniopublicacion > 1450 || aniopublicacion < 2025){
            throw new IllegalArgumentException("El año de publicación, no puede ser menor de 1450 y mayor al año actual: 2025");
        }
        this.aniopublicacion = aniopublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", aniopublicacion=" + aniopublicacion + ", autor=" + autor + '}';
    }

    
}
