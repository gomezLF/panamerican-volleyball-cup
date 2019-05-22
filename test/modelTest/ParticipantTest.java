package modelTest;

import model.Participant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    private Participant participant;
    private String message;

    private void setupScenary1(){

    }

    private void setupScenary2(){
        participant = new Participant("Felipe", "Andrade", "1523548", "gomez@Hotmail.com", "Male", "Colombia", "google.com", "5/18/1999");
    }

    private void setupScenary3(){
        setupScenary2();

        message = "Nombre: " + participant.getName() + " " + participant.getLastName() + "\n" + "ID: " + participant.getId() + "\n" + "E-mail: " + participant.getEmail() + "\n" + "Género: " + participant.getGender() + "\n" + "País: " + participant.getCountry() + "\n" + "Cumpleaños: " + participant.getBirthday();
    }

    @Test
    void ParticipantTest(){
        setupScenary1();

        String n = "Luis Felipe";
        String ln = "Gomez";
        String id = "1122334455";
        String e = "gomez99@hotmail.com";
        String g = "Male";
        String c = "Colombia";
        String a = "google.com";
        String b = "1/12/1972";

        participant = new Participant(n, ln, id, e, g, c, a, b);

        assertNotNull(participant.getName(), "El nombre del participante es null");
        assertNotNull(participant.getLastName(), "El apellido del participante es null");
        assertNotNull(participant.getId(), "El id del participante es null");
        assertNotNull(participant.getEmail(), "El email del participante es null");
        assertNotNull(participant.getGender(), "El genero del participante es null");
        assertNotNull(participant.getCountry(), "El pais del participante es null");
        assertNotNull(participant.getAvatar(), "El avatar del participante es null");
        assertNotNull(participant.getBirthday(), "La fecha de nacimiento del participante es null");

        assertTrue(participant.getName().equals(n), "Los nombres no son iguales");
        assertTrue(participant.getLastName().equals(ln), "Los apellidos no son iguales");
        assertTrue(participant.getEmail().equals(e), "Los correos no son iguales");
        assertTrue(participant.getGender().equals(g), "Los generos no son iguales");
        assertTrue(participant.getCountry().equals(c), "Los paises no son iguales");
        assertTrue(participant.getAvatar().equals(a), "Los avatares no son iguales");
        assertTrue(participant.getBirthday().equals(b), "Las fechas de cumpleaños no son iguales");
        assertTrue(participant.getId().equals(id), "Los id no son iguales");
    }

    @Test
    void compareToTest(){
        setupScenary2();

        String id_1 = "1523548";
        String id_2 = "6546456";
        String id_3 = "0065465";

        int equal = participant.compareTo(id_1);
        int higher = participant.compareTo(id_2);
        int less = participant.compareTo(id_3);

        assertEquals(0, equal, "No son iguales");
        assertEquals(1, higher, "No es mayor");
        assertEquals(-1, less, "No es menor");
    }

    @Test
    void ToStringTest(){
        setupScenary3();

        String returned = participant.toString();

        assertEquals(message, returned, "El mensaje retornado no es el esperado");
    }

}