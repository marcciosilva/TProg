/*
 * Header Test
 */
package tprog.logica.dt;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DTUsuarioTest {

    private DTUsuario instance;
    private Date fecha;

    public DTUsuarioTest() {
    }

    @Before
    public void setUp() {
        fecha = new Date();
        instance = new DTUsuario("nick", "pass", "nombre", "apellido", "nombre.apellido@email.com", "imagen", fecha);
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        String expResult = "apellido";
        String result = instance.getApellido();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        String expResult = "nick";
        String result = instance.getNickname();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "password";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "nombre.apellido@email.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        String expResult = "imagen";
        String result = instance.getImagen();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaNacimiento() {
        System.out.println("getFechaNacimiento");
        Date expResult = fecha;
        Date result = instance.getFechaNacimiento();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Nickname: " + "nick"
                + "\n" + "Nombre: " + "nombre"
                + "\n" + "Apellido: " + "apellido"
                + "\n" + "Email: " + "nombre.apellido@email.com"
                + "\n" + "Fecha de nacimiento: "
                + Integer.toString(fecha.getDate()) + "-"
                + Integer.toString(fecha.getMonth() + 1) + "-"
                + Integer.toString(fecha.getYear()) + "\n";

        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
