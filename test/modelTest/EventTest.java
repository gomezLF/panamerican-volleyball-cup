package modelTest;

import model.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private Event event;
    private String[] positions;

    private void setupScenary1(){

    }

    private void setupScenary2(){
        event = new Event();
    }

    @Test
    void EventTest(){
        setupScenary1();

        event = new Event();

        assertNotNull(event, "El parametro event aún es null");

        assertNull(event.getRoot(), "La raiz del arbol principal no es nulo");
        assertNull(event.getCountrySpectatorRoot(), "La raiz del arbol de nacionalidad no es nulo");
    }

    @Test
    void readDataTest(){

    }

}