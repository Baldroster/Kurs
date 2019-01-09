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
import java.util.ArrayList;
import java.util.List;

public class RoomSearchController {
    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField fieldRoomId;

    @FXML
    private TextField fieldRoomPrice;

    @FXML
    private TextField fieldRoomCommentary;

    @FXML
    private Label errorLabel;

    private Room room = new Room();
    private List<Room> searchedRooms = new ArrayList<Room>();
    private int index = 0;

    @FXML
    private void clickSearchButton() throws SQLException {
       receiveValueFromFields();
        if(room.checkValidation()){
            if(SqlQuery.checkStatementDoesExist(SqlQuery.generateSqlSearchRoom(room)))
            {
                searchedRooms = SqlQuery.getRoomQuery(SqlQuery.generateSqlSearchRoom(room));
                fillTextareas();
                convertWindowIntoSearchResults();
            }
            else {
                clearTextAreas();
                errorLabel.setText("Значений не найдено");
                errorLabel.setVisible(true);
            }
        }
        else {
            clearTextAreas();
            errorLabel.setText("Введите верные значения");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    private void clickNextButton(){
        index++;
        disableNavigateButtons();
        fillTextareas();
    }

    @FXML
    private void clickPreviousButton(){
        index--;
        disableNavigateButtons();
        fillTextareas();
    }

    @FXML
    private void clickSaveButton() throws IOException, SQLException {
        receiveValueFromFields();
        if(room.checkValidationInsert()){

                receiveValueFromFields();
                SqlQuery.deleteRoom(room);
                SqlQuery.setRoom(room);
                returnToMainWindow();
        }
        else {
            fillTextareas();
            errorLabel.setText("Введите верные значения");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    private void clickDeleteButton() throws IOException, SQLException {
        receiveValueFromFields();
        SqlQuery.deleteRoom(room);
        returnToMainWindow();
    }

    @FXML
    private void clickBackButton() throws IOException {
        returnToMainWindow();
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

    private void clearTextAreas(){
        fieldRoomId.setText("");
        fieldRoomPrice.setText("");
        fieldRoomCommentary.setText("");
    }

    private void convertWindowIntoSearchResults(){
        saveButton.setVisible(true);
        nextButton.setVisible(true);
        previousButton.setVisible(true);
        deleteButton.setVisible(true);
        searchButton.setVisible(false);
        disableNavigateButtons();
        fieldRoomId.setDisable(true);
    }

    private void disableNavigateButtons(){
        if(searchedRooms.size()-1 == index)
        {
            nextButton.setDisable(true);
        }
        else{
            nextButton.setDisable(false);
        }
        if(index == 0){
            previousButton.setDisable(true);
        }
        else{
            previousButton.setDisable(false);
        }
    }

    private void fillTextareas(){
        fieldRoomId.setText(searchedRooms.get(index).getId());
        fieldRoomPrice.setText(searchedRooms.get(index).getPrice());
        fieldRoomCommentary.setText(searchedRooms.get(index).getCommentary());
    }

    private void receiveValueFromFields(){
        room.setId(fieldRoomId.getCharacters().toString());
        room.setPrice(fieldRoomPrice.getCharacters().toString());
        room.setCommentary(fieldRoomCommentary.getCharacters().toString());
    }

}
