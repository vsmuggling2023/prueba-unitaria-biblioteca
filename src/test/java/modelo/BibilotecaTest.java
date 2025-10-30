/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


/**
 *
 * @author Santo Tomas
 */

public class BibilotecaTest {
    
    @Test
    public void testAutorValido(){
        Autor a = new Autor(1,"Fulano","Fulano");
        assertEquals("Fulano", a.getNombre());
        assertEquals("Fulano", a.getNacionalidad());
    }
    @Test
    public void agregarLibroBibliotecaValido() {
        
        Autor autor = new Autor(1, "Gabriel García Márquez", "Colombiana");
        Libro libro = new Libro(1, "Cien años de soledad", 1967, autor);

        Biblioteca biblioteca = new Biblioteca(1);
        biblioteca.agregarLibros(libro);

        assertEquals(1, biblioteca.getLibros().size());
        assertEquals("Cien años de soledad", biblioteca.getLibros().get(0).getTitulo());
        assertEquals("Gabriel García Márquez", biblioteca.getLibros().get(0).getAutor().getNombre());
        assertEquals("Colombiana", biblioteca.getLibros().get(0).getAutor().getNacionalidad());
    }
    
    @Test
    public void listarLibros_VerificarTotalCoincideConAgregados() {
        Autor autor1 = new Autor(1, "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor(2, "Isabel Allende", "Chilena");
        Autor autor3 = new Autor(3, "Mario Vargas Llosa", "Peruana");

        Libro libro1 = new Libro(1, "Cien años de soledad", 1967, autor1);
        Libro libro2 = new Libro(2, "La casa de los espíritus", 1982, autor2);
        Libro libro3 = new Libro(3, "La ciudad y los perros", 1963, autor3);

        Biblioteca biblioteca = new Biblioteca(1);

        biblioteca.agregarLibros(libro1);
        biblioteca.agregarLibros(libro2);
        biblioteca.agregarLibros(libro3);

        List<Libro> librosListados = biblioteca.listarLibros();

        assertEquals(3, librosListados.size());

        assertTrue(librosListados.contains(libro1));
        assertTrue(librosListados.contains(libro2));
        assertTrue(librosListados.contains(libro3));
    }
    
    @Test
    public void actualizarLibro_ValidarCambios() {
        Autor autorOriginal = new Autor(1, "Gabriel García Márquez", "Colombiana");
        Libro libro = new Libro(1, "Cien años de soledad", 1967, autorOriginal);

        Biblioteca biblioteca = new Biblioteca(1);
        biblioteca.agregarLibros(libro);

        Autor nuevoAutor = new Autor(2, "Gabriel García Márquez", "Colombiana"); // mismo autor, por simplicidad
        String nuevoTitulo = "Cien años de soledad (Edición Especial)";
        int nuevoAnio = 1970;

        biblioteca.actualizarLibro(libro.getId(), nuevoTitulo, nuevoAnio, nuevoAutor);

        Libro libroActualizado = biblioteca.buscarLibroPorId(libro.getId());

        assertEquals(nuevoTitulo, libroActualizado.getTitulo());
        assertEquals(nuevoAnio, libroActualizado.getAniopublicacion());
        assertEquals(nuevoAutor, libroActualizado.getAutor());
    }
    
    @Test
    public void eliminarLibro_VerificarNoEstaEnLista() {
        Autor autor = new Autor(1, "Gabriel García Márquez", "Colombiana");
        Libro libro = new Libro(1, "Cien años de soledad", 1967, autor);

        Biblioteca biblioteca = new Biblioteca(1);
        biblioteca.agregarLibros(libro);

        assertTrue(biblioteca.listarLibros().contains(libro));

        biblioteca.eliminarLibro(libro.getId());

        assertFalse(biblioteca.listarLibros().contains(libro));
        assertEquals(0, biblioteca.listarLibros().size());
    }
    @Test
    public void testTituloVacio() {
        Autor autor = new Autor(1, "Gabriel García Márquez", "Colombiana");

        Exception ex = assertThrows(NullPointerException.class, () -> {
            new Libro(1, "", 1967, autor);
        });

        assertTrue(ex.getMessage().toLowerCase().contains("titulo"));
    }

    
    @Test
    public void testAnioInvalido() {
        Autor autor = new Autor(1, "Gabriel García Márquez", "Colombiana");

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Libro(1, "Cien años de soledad", 1400, autor);
        });

        assertTrue(ex.getMessage().toLowerCase().contains("año"));
    }
    @Test
    public void testAutorNulo() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            new Libro(1, "Cien años de soledad", 1967, null);
        });

         assertTrue(ex.getMessage().toLowerCase().contains("autor"));
    }

    @Test
    public void testLibroDuplicado() {
        Biblioteca biblioteca = new Biblioteca(1);
        Autor autor = new Autor(1, "Gabriel García Márquez", "Colombiana");

        Libro libro1 = new Libro(1, "Cien años de soledad", 1967, autor);
        Libro libro2 = new Libro(2, "Cien años de soledad", 1967, autor); // mismo título y autor

        biblioteca.agregarLibros(libro1);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.agregarLibros(libro2);
        });

        assertTrue(ex.getMessage().toLowerCase().contains("ya existe"));
    }
    @Test
    public void testMasDe100Libros() {
        Biblioteca biblioteca = new Biblioteca(1);
        Autor autor = new Autor(1, "Autor", "Nacionalidad");

        for (int i = 1; i <= 100; i++) {
            Libro libro = new Libro(i, "Libro " + i, 2000, autor);
            biblioteca.agregarLibros(libro);
        }

        Libro libroExtra = new Libro(101, "Libro extra", 2020, autor);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.agregarLibros(libroExtra);
        });

        assertTrue(ex.getMessage().toLowerCase().contains("100"));
    }
     @Test
    public void testActualizarOEliminarLibroInexistente() {
        Biblioteca biblioteca = new Biblioteca(1);
        Autor autor = new Autor(1, "Gabriel García Márquez", "Colombiana");

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.actualizarLibro(99, "Título nuevo", 2000, autor);
        });
        assertTrue(ex1.getMessage().toLowerCase().contains("no se encontró"));

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.eliminarLibro(99);
        });
        assertTrue(ex2.getMessage().toLowerCase().contains("no se encontró"));
    }
}
