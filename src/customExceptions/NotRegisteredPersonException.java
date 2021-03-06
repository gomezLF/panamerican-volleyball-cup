package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NotRegisteredPersonException extends Exception {

    public NotRegisteredPersonException() {
        super("Para poder realizar una busqueda, se deben registrar primero a los espectadores");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "No hay espectadores registrados en el evento", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
