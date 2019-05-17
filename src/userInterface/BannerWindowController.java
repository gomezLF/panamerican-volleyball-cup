package userInterface;

import customExceptions.EmptyDataException;
import customExceptions.NotRegisteredPersonException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.jfoenix.controls.JFXTextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Event;
import model.Participant;
import model.Spectator;

import java.io.File;
import java.io.IOException;


public class BannerWindowController {

    private Event event;

    @FXML
    private TextField pathFileTxt;

    @FXML
    private Label dataNotice;

    @FXML
    private JFXTextField searchSpectatorTxt;

    @FXML
    private Label spectatorTime;

    @FXML
    private JFXTextField searchParticipantTxt;

    @FXML
    private Label participantTime;

    @FXML
    private ImageView avatarImage;

    @FXML
    private TextArea personDataTxt;

    @FXML
    private JFXTextField countryStructureTxt;

    @FXML
    private ScrollPane structurePane;



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
            Spectator s = this.event.searchSpectator(searchSpectatorTxt.getText());
            showSpectator(s);

        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Espectador no registrado o incorrecto id", ButtonType.CLOSE);
            alert.setHeaderText("Espectador no encontrado");
            alert.show();

        }catch (EmptyDataException e){
            e.messsage();

        }catch (NotRegisteredPersonException e){
            e.message();
        }
    }

    @FXML
    void searchParticipantClicked(ActionEvent event) {
        try {
            Participant p =  this.event.searchParticipant(searchParticipantTxt.getText());
            showParticipant(p);

        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Participante no registrado o incorrecto id", ButtonType.CLOSE);
            alert.setHeaderText("Participante no encontrado");
            alert.show();

        }catch (EmptyDataException e){
            e.messsage();

        }catch (NotRegisteredPersonException e){
            e.message();
        }
    }



    @FXML
    void spectatorStructureClicked(ActionEvent event) {

    }

    @FXML
    void participantStructureClicked(ActionEvent event) {

    }



    private void showSpectator(Spectator spectator) {
        avatarImage.setImage(new Image(spectator.getAvatar()));
        personDataTxt.setText(spectator.toString());
    }

    private void showParticipant(Participant participant){
        avatarImage.setImage(new Image(participant.getAvatar()));
        personDataTxt.setText(participant.toString());
    }
}
