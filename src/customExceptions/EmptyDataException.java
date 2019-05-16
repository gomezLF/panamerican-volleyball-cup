package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EmptyDataException extends Exception {

    public EmptyDataException() {
        super("Para poder realizar la acción deseada, se deben de llenar todos los campos requeridos.");
    }


    public void messsage(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Algunos campos requeridos estan sin llenar.", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
