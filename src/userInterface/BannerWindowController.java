package userInterface;

import customExceptions.EmptyDataException;
import customExceptions.NotRegisteredPersonException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Event;
import model.Participant;
import model.Spectator;

import java.io.File;
import java.io.IOException;
import java.util.List;


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

            long startTime = System.nanoTime();
            Spectator s = this.event.searchSpectator(searchSpectatorTxt.getText());
            long endTime = System.nanoTime();

            showSpectator(s);
            spectatorTime.setText(this.event.calculateTime(startTime, endTime)/1e6 + " ms");

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

            long startTime = System.nanoTime();
            Participant p =  this.event.searchParticipant(searchParticipantTxt.getText());
            long endTime = System.nanoTime();

            showParticipant(p);
            participantTime.setText(this.event.calculateTime(startTime, endTime)/1e6 + " ms");

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
        List<Participant> list = null;

        try {
            list = this.event.linkedListToList(countryStructureTxt.getText());

            Pane pane = new Pane();
            int x = 0;
            for (int i = 0; i < list.size(); i++) {
                Rectangle rectangle = new Rectangle();

                rectangle.setX(x);
                rectangle.setY(50);
                rectangle.setWidth(300);
                rectangle.setHeight(300);
                rectangle.setFill(Color.DARKORANGE);

                pane.getChildren().addAll(rectangle, createImageView(rectangle, list.get(i).getAvatar()), createTextArea(rectangle, list.get(i).toString()));

                if (i != list.size() - 1){
                    Line next = new Line(rectangle.getX() + 300, rectangle.getY() + 135, rectangle.getX() + 900, rectangle.getY() + 135);
                    Line prev = new Line(rectangle.getX() + 300, rectangle.getY() + 165, rectangle.getX() + 900, rectangle.getY() + 165);

                    pane.getChildren().addAll(next, prev);
                }
                x = x + 600;
            }
            structurePane.setContent(pane);

        } catch (EmptyDataException e) {
            e.messsage();
        } catch (NotRegisteredPersonException e) {
            e.message();
        }
    }



    private TextArea createTextArea(Rectangle rectangle, String information){
        TextArea textArea = new TextArea();
        textArea.setLayoutX(rectangle.getX());
        textArea.setLayoutY(225);
        textArea.setPrefWidth(rectangle.getWidth());
        textArea.setPrefHeight(rectangle.getHeight()/2);
        textArea.setText(information);

        return  textArea;
    }

    private ImageView createImageView(Rectangle rectangle,  String avatar){
        ImageView imageView = new ImageView(new Image(avatar));
        imageView.setX(rectangle.getX() + 75);
        imageView.setY(rectangle.getY());
        imageView.setFitWidth(150);
        imageView.setFitHeight(rectangle.getHeight()/2);

        return imageView;
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
