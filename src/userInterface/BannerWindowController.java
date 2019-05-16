package userInterface;

import customExceptions.EmptyDataException;
import customExceptions.NotRegisteredPeopleException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Event;

import java.io.File;
import java.io.IOException;


public class BannerWindowController {

    private Event event;

    @FXML
    private TextField pathFileTxt;

    @FXML
    private Label dataNotice;

    @FXML
    private TextField searchSpectatorTxt;

    @FXML
    private Label spectatorTime;

    @FXML
    private Label spectatorNotice;

    @FXML
    private TextField searchParticipantTxt;

    @FXML
    private Label participantTime;

    @FXML
    private Label participantNotice;

    @FXML
    private ImageView avatarImage;

    @FXML
    private TextArea personDataTxt;

    @FXML
    private Pane structurePane;



    @FXML
    void initialize() {
        this.event = new Event();
    }



    @FXML
    void exploreClicked(ActionEvent event) {
        Stage stage = new Stage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir el archivo de recusos");
        File file = fileChooser.showOpenDialog(stage);

        if (file != null){
            pathFileTxt.setText(file.getAbsolutePath());
        }
    }

    @FXML
    void uploadClicked(ActionEvent event) {
        try {
            this.event.readData(pathFileTxt.getText());
            dataNotice.setText("Los espectadores han sido registrados al evento exitosamente");

        }catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Archivo no seleccionado o  Archivo incorrecto", ButtonType.CLOSE);
            alert.setHeaderText("Archivo no encontrado o archivo corrupto");
            alert.show();
        }
    }



    @FXML
    void searchSpectatorClicked(ActionEvent event) {
        try{
            this.event.searchSpectator(searchSpectatorTxt.getText());

        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Espectador no registrado o incorrecto id", ButtonType.CLOSE);
            alert.setHeaderText("Espectador no encontrado");
            alert.show();

        }catch (EmptyDataException e){
            e.messsage();
        }catch (NotRegisteredPeopleException e){
            e.message();
        }
    }

    @FXML
    void searchParticipantClicked(ActionEvent event) {

    }



    @FXML
    void spectatorStructureClicked(ActionEvent event) {

    }

    @FXML
    void participantStructureClicked(ActionEvent event) {

    }
}
