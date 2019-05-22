package modelTest;

import model.Spectator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpectatorTest {

    private Spectator spectator;
    private Spectator left;
    private Spectator right;

    private List<Spectator> spectatorList;

    private String message;

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
        Spectator s2 = new Spectator("Zsazsa", "Pellatt", "99-8514599","zpellatt5@latimes.com", "Female", "Nicaragua", "google.com", "10/24/2008");

        spectator.addSpectator(left);
        spectator.addSpectator(right);
        spectator.addSpectator(s1);
        spectator.addSpectator(s2);
    }

    private void setupScenary4(){
        setupScenary3();

        Spectator s1 = new Spectator("Heywood", "Gringley", "04-2599362", "hgringleyj@biglobe.ne.jp", "Male", "Nicaragua", "https://robohash.org/quiaestdolore.jpg?size=200x200&set=set1", "4/20/1981");
        Spectator s2 = new Spectator("Caty", "Barkaway", "03-1338300", "cbarkaway2@acquirethisname.com", "Female", "Nicaragua", "https://robohash.org/voluptatemsaepeaut.jpg?size=200x200&set=set1", "4/8/1990");
        Spectator s3 = new Spectator("Layla", "Fergyson", "42-1300339", "lfergysona@ted.com", "Female", "Nicaragua", "https://robohash.org/adverototam.jpg?size=200x200&set=set1","4/10/1978");
        Spectator s4 = new Spectator("Ilise", "Timbs", "29-3467986", "itimbs8@feedburner.com", "Female", "Nicaragua", "https://robohash.org/laborequasinostrum.jpg?size=200x200&set=set1", "10/24/2008");
        Spectator s5 = new Spectator("Pepito", "Perez", "00-0000000", "pepito@gmail.com", "Male", "Nicaragua", "google.com", "9/20/2005");

        spectator.addSpectator(s1);
        spectator.addSpectator(s2);
        spectator.addSpectator(s3);
        spectator.addSpectator(s4);
        spectator.addSpectator(s5);


    }

    private void setupScenary5(){
        setupScenary2();
        spectatorList = new ArrayList<>();

        Spectator s1 = new Spectator("Heywood", "Gringley", "04-2599362", "hgringleyj@biglobe.ne.jp", "Male", "Nicaragua", "google.com", "4/20/1981");
        Spectator s2 = new Spectator("Caty", "Barkaway", "03-1338300", "cbarkaway2@acquirethisname.com", "Female", "Nicaragua", "google.com", "4/8/1990");
        Spectator s3 = new Spectator("Layla", "Fergyson", "42-1300339", "lfergysona@ted.com", "Female", "Nicaragua", "google.com","4/10/1978");
        Spectator s4 = new Spectator("Ilise", "Timbs", "29-3467986", "itimbs8@feedburner.com", "Female", "Nicaragua", "google.com", "10/24/2008");
        Spectator s5 = new Spectator("Pepito", "Perez", "00-0000000", "pepito@gmail.com", "Male", "Nicaragua", "google.com", "9/20/2005");

        spectator.addSpectator(left);
        spectator.addSpectator(right);
        spectator.addSpectator(s1);
        spectator.addSpectator(s2);
        spectator.addSpectator(s3);
        spectator.addSpectator(s4);
        spectator.addSpectator(s5);

        spectatorList.add(s5);
        spectatorList.add(s2);
        spectatorList.add(s4);
        spectatorList.add(s3);
        spectatorList.add(s1);
        spectatorList.add(left);
        spectatorList.add(right);
        spectatorList.add(spectator);
    }

    private void setupScenary6(){
        spectator = new Spectator("Felipe", "Andrade", "1523548", "gomez@Hotmail.com", "Male", "Colombia", "google.com", "5/18/1999");

        message = "Nombre: " + spectator.getName() + " " + spectator.getLastName() + "\n" + "ID: " + spectator.getId() + "\n" + "E-mail: " + spectator.getEmail() + "\n" + "Género: " + spectator.getGender() + "\n" + "País: " + spectator.getCountry() + "\n" + "Cumpleaños: " + spectator.getBirthday();
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

    @Test
    void preOrderTest1(){
        setupScenary4();

        List<Spectator> list = new ArrayList<>();

        spectator.preOrder(list, "Nicaragua");

        for (int i = 0; i < list.size(); i++) {
            assertEquals("Nicaragua", list.get(i).getCountry(), "Los paises en la posicion " + "i " + "no son iguales");
        }

        assertEquals(7, list.size(), "El tamaño no es el mismo en preOrden1");
    }

    @Test
    void preOrderTest2(){
        setupScenary4();

        List<Spectator> list = new ArrayList<>();

        spectator.preOrder(list);

        assertEquals(10, list.size(), "El tamaño no es el mismo en preOrden2");
    }

    @Test
    void postOrder(){
        setupScenary5();

        List<Spectator> list = new ArrayList<>();
        spectator.postOrder(list);

        assertEquals(spectatorList.size(), list.size(), "El tamano no es el mismo en postOrden");

        for (int i = 0; i < list.size(); i++) {
            assertEquals(spectatorList.get(i).getId(), list.get(i).getId(), "No es el mismo ID en posicion " + i);
        }
    }

    @Test
    void ToStringTest(){
        setupScenary6();

        String returned = spectator.toString();

        assertEquals(message, returned, "El mensaje retornado no es el esperado");
    }

}