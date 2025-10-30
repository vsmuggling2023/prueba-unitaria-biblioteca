/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Santo Tomas
 */
import java.util.ArrayList;
import java.util.List;

public class Biblioteca{
    private int id;
    private List<Libro> libros;
    
     public Biblioteca(int id) {
        this.id = id;
        this.libros = new ArrayList<>(); 
    }

    public Biblioteca() {
    }

    public Biblioteca(int id, List<Libro> libros) {
        this.id = id;
        this.libros = libros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
     
    public void agregarLibros(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("No se puede agregar un libro nulo.");
        }

        // 🚫 Limitar a 100 libros
        if (libros.size() >= 100) {
            throw new IllegalArgumentException("No se pueden agregar más de 100 libros a la biblioteca.");
        }

        // 🚫 Evitar duplicados (mismo título y autor)
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(libro.getTitulo()) &&
                l.getAutor().getNombre().equalsIgnoreCase(libro.getAutor().getNombre())) {
                throw new IllegalArgumentException("El libro '" + libro.getTitulo() + "' ya existe en la biblioteca.");
            }
        }

        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }
    
    public List<Libro> listarLibros() {
        return this.libros;
    }
    
    public void actualizarLibro(int idLibro, String nuevoTitulo, int nuevoAnio, Autor nuevoAutor) {
        // Validación 1: Buscar si el libro existe.
        Libro libroParaActualizar = buscarLibroPorId(idLibro);
        
        if (libroParaActualizar == null) {
            throw new IllegalArgumentException("No se encontró el libro con ID " + idLibro + " para actualizar.");
        }
        
        try {
            libroParaActualizar.setTitulo(nuevoTitulo);
            libroParaActualizar.setAniopublicacion(nuevoAnio);
            libroParaActualizar.setAutor(nuevoAutor);
            System.out.println("Libro actualizado: " + libroParaActualizar.getTitulo());
        } catch (IllegalArgumentException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }
    
    public void eliminarLibro(int idLibro) {
        Libro libroParaEliminar = buscarLibroPorId(idLibro);
        
        if (libroParaEliminar == null) {
            throw new IllegalArgumentException("No se encontró el libro con ID " + idLibro + " para eliminar.");
        }

        this.libros.remove(libroParaEliminar);
        System.out.println("Libro eliminado: " + libroParaEliminar.getTitulo());
    }
    
    public Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro; // Lo encontró
            }
        }
        return null; // No lo encontró
    }
    
}   
