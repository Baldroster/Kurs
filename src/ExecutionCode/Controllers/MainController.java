package ExecutionCode.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button buttonInputRoom;

    @FXML
    private Button buttonSearchRoom;

    @FXML
    private Button buttonInputWorker;

    @FXML
    private Button buttonSearchWorker;

    @FXML
    private Button buttonInputGuest;

    @FXML
    private Button buttonSearchGuest;

    @FXML
    private void clickButtonInputRoom() throws IOException {
        Stage stage = (Stage) buttonInputRoom.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/roomInsert.fxml"));
        stage = new Stage();
        stage.setTitle("Окно ввода данных о комнате");
        stage.setScene(new Scene(root, 423, 382));
        stage.show();
    }

    @FXML
    private void clickButtonSearchRoom() throws IOException {
        Stage stage = (Stage) buttonInputRoom.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/roomSearch.fxml"));
        stage = new Stage();
        stage.setTitle("Окно поиска данных о комнате");
        stage.setScene(new Scene(root, 423, 382));
        stage.show();
    }

    @FXML
    private void clickButtonInputGuest() throws IOException {
        Stage stage = (Stage) buttonInputGuest.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/guestInsert.fxml"));
        stage = new Stage();
        stage.setTitle("Окно ввода данных о госте");
        stage.setScene(new Scene(root, 453, 552));
        stage.show();
    }

    @FXML
    private void clickButtonSearchGuest() throws IOException {
        Stage stage = (Stage) buttonSearchGuest.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/guestSearch.fxml"));
        stage = new Stage();
        stage.setTitle("Окно поиска данных о госте");
        stage.setScene(new Scene(root, 453, 552));
        stage.show();
    }

    @FXML
    private void clickButtonInputWorker() throws IOException {
        Stage stage = (Stage) buttonInputWorker.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/workerInsert.fxml"));
        stage = new Stage();
        stage.setTitle("Окно ввода данных о работнике");
        stage.setScene(new Scene(root, 453, 552));
        stage.show();
    }

    @FXML
    private void clickButtonSearchWorker() throws IOException {
        Stage stage = (Stage) buttonSearchWorker.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/workerSearch.fxml"));
        stage = new Stage();
        stage.setTitle("Окно поиска данных о работнике");
        stage.setScene(new Scene(root, 453, 552));
        stage.show();
    }
}
