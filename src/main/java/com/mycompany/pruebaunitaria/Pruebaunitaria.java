/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaunitaria;
import modelo.Biblioteca;
import modelo.Autor;
import modelo.Libro;

/**
 *
 * @author Santo Tomas
 */
public class Pruebaunitaria {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca(1);
        
        Autor autor1 = new Autor(1, "Gabriel García Márquez", "Colombiano");
        Autor autor2 = new Autor(2, "Isabel Allende", "Chilena");
        Libro libro1 = new Libro(101, "Cien años de soledad", 1967, autor1);
        Libro libro2 = new Libro(102, "La casa de los espíritus", 1982, autor2);
    }

}
