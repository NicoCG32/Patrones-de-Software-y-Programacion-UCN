package cl.ucn.solicitudes.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EstudianteTest {

    private Estudiante e;

    @Test(expected = IllegalArgumentException.class)
    public void creacionEstudianteNombreVacio(){
        e = new Estudiante("","nico@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void creacionEstudianteCorreoVacio(){
        e = new Estudiante("nicopablo","");
    }

    @Test
    public void instanciarCorrectamenteEstudiante(){
        e = new Estudiante("Nico","nico@gmail.com");
        assertEquals(e.getNombre(),"Nico");
        assertEquals(e.getCorreo(),"nico@gmail.com");
    }
}
