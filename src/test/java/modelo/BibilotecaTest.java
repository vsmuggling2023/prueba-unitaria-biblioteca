/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
