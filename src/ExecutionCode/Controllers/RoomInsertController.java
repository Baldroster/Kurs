package ExecutionCode.Controllers;

import ExecutionCode.BaseObjects.Room;
import ExecutionCode.Database.SqlQuery;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;

public class RoomInsertController {

    private Room room = new Room();

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField fieldRoomId;

    @FXML
    private TextField fieldRoomPrice;

    @FXML
    private TextField fieldRoomCommentary;

    @FXML
    private Label errorLabel;

    @FXML
    private void clickBackButton() throws IOException {
       returnToMainWindow();
    }

    @FXML
    private void clickSaveButton() throws SQLException, IOException {
       receiveValueFromFields();
        if(room.checkValidationInsert()){
            if (SqlQuery.checkNotDuplicateRoom(room)){
                SqlQuery.setRoom(room);
                returnToMainWindow();
            }
            else{
                fieldRoomId.setText("");
                errorLabel.setText("Данная комната уже существует");
                errorLabel.setVisible(true);
            }
        }
        else {
            clearTextAreas();
            errorLabel.setText("Введите верные значения");
            errorLabel.setVisible(true);
        }
    }

    private void clearTextAreas(){
        fieldRoomId.setText("");
        fieldRoomPrice.setText("");
        fieldRoomCommentary.setText("");
    }
    private  void returnToMainWindow() throws IOException {
        Stage stage = (Stage) fieldRoomId.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/MainForm.fxml"));
        stage = new Stage();
        stage.setTitle("Главное Окно");
        stage.setScene(new Scene(root, 380, 400));
        stage.show();
    }

    private void receiveValueFromFields(){
        room.setId(fieldRoomId.getCharacters().toString());
        room.setPrice(fieldRoomPrice.getCharacters().toString());
        room.setCommentary(fieldRoomCommentary.getCharacters().toString());
    }
}