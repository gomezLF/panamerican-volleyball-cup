package modelTest;

import model.Spectator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpectatorTest {

    private Spectator spectator;
    private Spectator left;
    private Spectator right;

    private void setupScenary1(){

    }

    private void setupScenary2(){
        spectator = new Spectator("Heywood", "Gringley", "97-5545511", "hgringleyj@biglobe.ne.jp", "Male", "Nicaragua", "https://robohash.org/quiaestdolore.jpg?size=200x200&set=set1", "4/20/1981");
        left = new Spectator("Cassy", "Burtwhistle", "81-8993344", "cburtwhistlei@hotmail.com", "Female", "Latvia", "google.com", "2/20/2008");
        right = new Spectator("Letisha", "McIllroy", "98-8514098", "lmcillroye@addtoany.com", "Female", "Poland", "google.com", "1/24/1982");
    }

    private void setupScenary3(){
        setupScenary2();

        Spectator s1 = new Spectator("Case", "Darracott", "05-9151344", "cdarracottb@shutterfly.com", "Male", "Honduras", "gogole.com", "6/2/1981");
        Spectator s2 = new Spectator("Zsazsa", "Pellatt", "99-8514599","zpellatt5@latimes.com", "Female", "Indonesia", "google.com", "10/24/2008");

        spectator.addSpectator(left);
        spectator.addSpectator(right);
        spectator.addSpectator(s1);
        spectator.addSpectator(s2);
    }

    @Test
    void SpectatorTest(){
        setupScenary1();

        String n = "Luis Felipe";
        String ln = "Gomez";
        String id = "1122334455";
        String e = "gomez99@hotmail.com";
        String g = "Male";
        String c = "Colombia";
        String a = "google.com";
        String b = "1/12/1972";

        spectator = new Spectator(n, ln, id, e, g, c, a, b);

        assertNotNull(spectator.getName(), "El nombre del participante es null");
        assertNotNull(spectator.getLastName(), "El apellido del participante es null");
        assertNotNull(spectator.getId(), "El id del participante es null");
        assertNotNull(spectator.getEmail(), "El email del participante es null");
        assertNotNull(spectator.getGender(), "El genero del participante es null");
        assertNotNull(spectator.getCountry(), "El pais del participante es null");
        assertNotNull(spectator.getAvatar(), "El avatar del participante es null");
        assertNotNull(spectator.getBirthday(), "La fecha de nacimiento del participante es null");

        assertTrue(spectator.getName().equals(n), "Los nombres no son iguales");
        assertTrue(spectator.getLastName().equals(ln), "Los apellidos no son iguales");
        assertTrue(spectator.getEmail().equals(e), "Los correos no son iguales");
        assertTrue(spectator.getGender().equals(g), "Los generos no son iguales");
        assertTrue(spectator.getCountry().equals(c), "Los paises no son iguales");
        assertTrue(spectator.getAvatar().equals(a), "Los avatares no son iguales");
        assertTrue(spectator.getBirthday().equals(b), "Las fechas de cumpleaños no son iguales");
        assertTrue(spectator.getId().equals(id), "Los id no son iguales");
    }

    @Test
    void addSpectatorTest(){
        setupScenary2();

        spectator.addSpectator(left);
        spectator.addSpectator(right);

        assertNotNull(spectator.getLeft());
        assertEquals(left.getId(), spectator.getLeft().getId(), "El ID izquierdo agregado no corresponde al correcto");

        assertNotNull(spectator.getRight());
        assertEquals(right.getId(), spectator.getRight().getId(), "El ID derecho agregado no corresponde al correcto");
    }

    @Test
    void searchTest(){
        setupScenary3();

        String searched_1 = "97-5545511";
        String searched_2 = "99-8514599";
        String searched_3 = "05-9151344";

        Spectator s1 = spectator.search(searched_1);
        Spectator s2 = spectator.search(searched_2);
        Spectator s3 = spectator.search(searched_3);

        assertEquals(searched_1, s1.getId(), "El ID en la bsuqueda 1 no es el mismo");
        assertEquals(searched_2, s2.getId(), "El ID en la bsuqueda 2 no es el mismo");
        assertEquals(searched_3, s3.getId(), "El ID en la bsuqueda 3 no es el mismo");
    }

}